package com.hardcoders.havajack.model.income

import java.util.*

public data class IncomeForm(
        val inn: String,
        val receiptId: String?,
        val requestTime: Date,
        val operationTime: Date,
        val incomeType: String?,
        val customerInn: String?,
        val customerOrganization: String?,
        val services: List<IncomeService>,
        val totalAmount: Double,
        val incomeHashCode: String?,
        val link: String?,
        val geoInfo: GeoInfo?,
        val operationUniqueId: String // Уникальный идентификатор операции
)

data class IncomeService(val name: String, val quantity: Int, val amount: Double)

data class GeoInfo(val longitude: Double, val latitude: Double)