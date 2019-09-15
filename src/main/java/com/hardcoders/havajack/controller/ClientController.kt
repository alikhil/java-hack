package com.hardcoders.havajack.controller

import com.hardcoders.havajack.model.Client
import com.hardcoders.havajack.model.registration.SmzAccountDto
import com.hardcoders.havajack.repository.ClientRepository
import com.hardcoders.havajack.service.SmzService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/client")
class ClientController(
        val clientRepository: ClientRepository,
        val smzService: SmzService
) {
    @PostMapping("/new")
    fun new(@RequestBody account: SmzAccountDto): String {
        smzService.createAccount(account)
        val client = Client(
                inn = account.inn,
                availableAmount = 0.0,
                lockedAmount = 0.0,
                tax = 0.04
                )
        clientRepository.save(client)
        return client.inn
    }

    @GetMapping("/info")
    fun getInfo(@RequestParam inn: String): Client? {
        val client = clientRepository.findByInn(inn)
        return if (client.isPresent) {
            client.get()
        } else {
            null
        }
    }

    @PostMapping("/pay")
    fun payTaxes(@RequestParam inn: String): String {
        var clientO = clientRepository.findByInn(inn)
        if (clientO.isPresent) {
            val client = clientO.get()
            client.availableAmount += client.lockedAmount * client.invest
            client.lockedAmount = 0.0
            clientRepository.save(client)
            // TODO: send money to Smz
            return "PAID"
        }
        return "USER_NOT_FOUND"
    }
}