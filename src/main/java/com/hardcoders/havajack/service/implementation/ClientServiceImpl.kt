package com.hardcoders.havajack.service.implementation

import com.hardcoders.havajack.model.Account
import com.hardcoders.havajack.model.Client
import com.hardcoders.havajack.model.registration.SmzAccountDto
import com.hardcoders.havajack.repository.AccountRepository
import com.hardcoders.havajack.repository.ClientRepository
import com.hardcoders.havajack.service.ClientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ClientServiceImpl @Autowired constructor (
        val clientRepository: ClientRepository,
        val accountRepository: AccountRepository
) : ClientService {
    override fun createClient(account: Account): Client {
        val client = Client(
                inn = "133732280",
                availableAmount = 0.0,
                lockedAmount = 0.0,
                tax = 0.04,
                account = account
        )
        return clientRepository.save(client)
    }

    fun createClient(account : SmzAccountDto): Client {
        val client = Client(
                inn = account.inn,
                availableAmount = 0.0,
                lockedAmount = 0.0,
                tax = 0.04,
                account = null
        )
        clientRepository.save(client)
        return client
    }

    override fun getClient(token: String): Client {
        var account = accountRepository.findByToken(token)
        val client = clientRepository.findByAccount(account)

        return client.get()
    }

    override fun payTaxes(token: String): String {
        var account = accountRepository.findByToken(token)
        val client = clientRepository.findByAccount(account)

        if (client.isPresent) {
            val client = client.get()
            client.availableAmount += client.lockedAmount * client.invest
            client.lockedAmount = 0.0
            clientRepository.save(client)
            // TODO: send money to Smz
            return "PAID"
        }
        return "USER_NOT_FOUND"
    }
}