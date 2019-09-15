package com.hardcoders.havajack.service.implementation

import com.hardcoders.havajack.model.Income
import com.hardcoders.havajack.model.SmzAccount
import com.hardcoders.havajack.model.income.IncomeForm
import com.hardcoders.havajack.model.income.Receipt
import com.hardcoders.havajack.model.income.ReceiptCancelationRequest
import com.hardcoders.havajack.model.income.ReciptCancelationResult
import com.hardcoders.havajack.model.registration.RegistrationRequestID
import com.hardcoders.havajack.model.registration.RegistrationRequestStatus
import com.hardcoders.havajack.model.registration.RegistrationResultStatus
import com.hardcoders.havajack.model.registration.SmzAccountDto
import com.hardcoders.havajack.repository.IncomeRepository
import com.hardcoders.havajack.repository.SmzAccountRepository
import com.hardcoders.havajack.service.SmzService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.*

// It's a bit hard to work with real Smz service for now
// because of lack of documentation and API_KEY
@Service
class SmzServiceFakeImpl @Autowired constructor(
        private val smzAccountRepository: SmzAccountRepository,
        private val incomeRepository: IncomeRepository
)
    : SmzService {
    override fun cancelReceipt(request: ReceiptCancelationRequest): ReciptCancelationResult {
        val income = incomeRepository.findById(request.receiptID.toLongOrNull() ?: 0)
        if (income.isPresent) {
            incomeRepository.delete(income.get())
        }
        return ReciptCancelationResult("DELETED")
    }

    override fun postIncome(income: IncomeForm): Receipt {
        val income = incomeRepository.save(Income(income))
        return Receipt(income.id.toString(), "https://needreceipt.com/restaurant2Default.png")
    }


    override fun createAccount(form: SmzAccountDto): RegistrationRequestID {
        val account = this.smzAccountRepository.save(SmzAccount(form))
        return account.id.toString()
    }

    override fun getCreateStatus(id: RegistrationRequestID): RegistrationRequestStatus {
        val account = this.smzAccountRepository.findById(id.toLongOrNull() ?: 0)
        val status = if (account.isPresent) RegistrationResultStatus.COMPLETED else RegistrationResultStatus.FAILED
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