package com.hardcoders.havajack.model.registration

import java.util.*


enum class RegistrationResultStatus {
    ORDER_REGISTERED, // заявка на постановку на учет принята. Означает что ПП Самозанятые приняла заявку, но она не передана в регистрирующую подсистему АИС Налог3.
    IN_PROGRESS, // исполнение, т.е. постановка на учет находится на рассмотрении в регистрирующей подсистеме АИС Налог3.
    COMPLETED,  // поставлен на учет подтверждена со стороны регистрирующей подсистемы АИС Налог3 (терминальный статус заявки).
    FAILED // постановка на учет отклонена
}


data class RegistrationRequestStatus(
        val requestResult: RegistrationResultStatus,
        val rejectionReason: String,
        val registrationTime: Date,
        val lastRegistrationTime: Date,
        val updateTime: Date,
        val unregistrationTime: Date,
        val bindRequestId: String, // ID запроса на согласование разрешений для партнера от НП НПД
        val registrationCertificateNumber: String, // Номер свидетельства о постановке на учет
        val inn: String)
