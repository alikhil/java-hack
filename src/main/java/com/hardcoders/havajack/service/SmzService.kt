package com.hardcoders.havajack.service

import com.hardcoders.havajack.model.registration.RegistrationRequestID
import com.hardcoders.havajack.model.registration.RegistrationRequestStatus
import com.hardcoders.havajack.model.registration.SmzAccountForm

interface SmzService {

    fun canCreateAccount(inn: String): Boolean

    fun createAccount(form: SmzAccountForm): RegistrationRequestID

    fun getCreateStatus(id: RegistrationRequestID): RegistrationRequestStatus
}