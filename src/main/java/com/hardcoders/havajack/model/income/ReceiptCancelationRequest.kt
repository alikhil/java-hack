package com.hardcoders.havajack.model.income

data class ReceiptCancelationRequest(
        val inn: String,
        val receiptID: String,
        val message: String
)

data class ReciptCancelationResult(
        val requestResult: String
)