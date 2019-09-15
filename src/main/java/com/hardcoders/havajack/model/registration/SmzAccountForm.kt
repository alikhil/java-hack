package com.hardcoders.havajack.model.registration

import org.codehaus.jackson.annotate.JsonCreator
import java.util.*


public data class SmzAccountForm @JsonCreator constructor(
    val inn: String,
    val firstName: String,
    val secondName: String,
    val patronymic: String?,
    val birthday: Date, // TODO: maybe string?
    val passportSeries: String?,
    val passportNumber: String?,
    val activities: List<String>,
    val phone: String,
    val email: String,
    val bankcardNumber: String,
    val bankcardAccountNumber: String,
    val requestTime: Date,
    val oktmo: String
)


