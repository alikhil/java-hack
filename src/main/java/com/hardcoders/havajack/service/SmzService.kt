package com.hardcoders.havajack.service

import com.hardcoders.havajack.model.income.IncomeForm
import com.hardcoders.havajack.model.income.Receipt
import com.hardcoders.havajack.model.income.ReceiptCancelationRequest
import com.hardcoders.havajack.model.income.ReciptCancelationResult
import com.hardcoders.havajack.model.registration.RegistrationRequestID
import com.hardcoders.havajack.model.registration.RegistrationRequestStatus
import com.hardcoders.havajack.model.registration.SmzAccountDto

interface SmzService {

    fun canCreateAccount(inn: String): Boolean

    fun createAccount(form: SmzAccountDto): RegistrationRequestID

    fun getCreateStatus(id: RegistrationRequestID): RegistrationRequestStatus

    fun postIncome(income: IncomeForm): Receipt

    fun cancelReceipt(request: ReceiptCancelationRequest): ReciptCancelationResult
}