package com.hardcoders.havajack.model

import com.hardcoders.havajack.model.registration.SmzAccountDto
import java.time.Instant
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
public class SmzAccount(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,

        val inn: String? = null,
        val firstName: String = "",
        val secondName: String = "",
        val patronymic: String? = null,
        val birthday: Date = Date.from(Instant.MIN),
        val passportSeries: String? = null,
        val passportNumber: String? = null,
        val activities: String = "", // separated by ','
        val phone: String,
        val email: String,
        val bankcardNumber: String,
        val bankcardAccountNumber: String,
        val requestTime: Date,
        val oktmo: String
        ) {

    constructor(form: SmzAccountDto) :
            this(inn = form.inn,
                    firstName = form.firstName,
                    secondName = form.secondName,
                    patronymic = form.patronymic,
                    birthday = form.birthday,
                    passportSeries = form.passportSeries,
                    passportNumber = form.passportNumber,
                    activities = form.activities.joinToString (separator = ","),
                    phone = form.phone,
                    email = form.email,
                    bankcardNumber = form.bankcardNumber,
                    bankcardAccountNumber = form.bankcardAccountNumber,
                    requestTime = form.requestTime,
                    oktmo = form.oktmo
                    ) {

    }
}