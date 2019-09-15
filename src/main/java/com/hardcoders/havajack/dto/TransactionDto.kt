package com.hardcoders.havajack.dto

import com.fasterxml.jackson.annotation.JsonCreator

data class TransactionDto  @JsonCreator constructor(
        val fromUser: String,
        val toUser: String,
        val amount: Double,
        val message: String)