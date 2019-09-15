package com.hardcoders.havajack.model

import com.hardcoders.havajack.model.income.IncomeForm
import java.time.Instant
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Income {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0

    var inn: String = ""
    var receiptId: String? = ""
    var requestTime: Date = Date.from(Instant.MIN)
    var operationTime: Date = Date.from(Instant.MIN)
    var incomeType: String? = null
    var customerInn: String? = null
    var customerOrganization: String? = null
    var servicesSummary: String = ""
    var totalAmount: Double = 0.0
    var operationUniqueId: String = ""
    var geoLatitude: Double = 0.0
    var geoLongitude: Double = 0.0

    constructor(form: IncomeForm) {
        this.requestTime = form.requestTime
//        this.
    }

}