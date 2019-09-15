package com.hardcoders.havajack.model

import com.fasterxml.jackson.annotation.JsonCreator

data class TransactionForm  @JsonCreator constructor(
        val fromUser: String,
        val toUser: String,
        val amount: Double,
        val message: String)