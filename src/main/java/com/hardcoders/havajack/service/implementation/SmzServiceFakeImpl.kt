package com.hardcoders.havajack.service.implementation

import com.hardcoders.havajack.model.SmzAccount
import com.hardcoders.havajack.model.registration.RegistrationRequestID
import com.hardcoders.havajack.model.registration.RegistrationRequestStatus
import com.hardcoders.havajack.model.registration.ResultStatus
import com.hardcoders.havajack.model.registration.SmzAccountForm
import com.hardcoders.havajack.repository.SmzAccountRepository
import com.hardcoders.havajack.service.SmzService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.*

// It's a bit hard to work with real Smz service for now
// because of lack of documentation and API_KEY
@Service
class SmzServiceFakeImpl @Autowired constructor(private val smzAccountRepository: SmzAccountRepository) : SmzService {

    override fun createAccount(form: SmzAccountForm): RegistrationRequestID {
        val account = this.smzAccountRepository.save(SmzAccount(form))
        return account.id.toString()
    }

    override fun getCreateStatus(id: RegistrationRequestID): RegistrationRequestStatus {
        val account = this.smzAccountRepository.findById(id.toLongOrNull() ?: 0)
        val status = if (account.isPresent) ResultStatus.COMPLETED else ResultStatus.FAILED
        val now = Date.from(Instant.now())
        // TODO: return some real data from account if it exists
        return RegistrationRequestStatus(
                requestResult = status,
                rejectionReason = "",
                registrationTime = now,
                lastRegistrationTime = now,
                updateTime = now,
                bindRequestId = "temp-value",
                inn = "temp-inn",
                registrationCertificateNumber = "temp-number",
                unregistrationTime = now)
    }

    override fun canCreateAccount(inn: String): Boolean {
        return true
    }
}