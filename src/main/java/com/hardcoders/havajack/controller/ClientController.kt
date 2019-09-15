package com.hardcoders.havajack.controller

import com.hardcoders.havajack.model.Client
import com.hardcoders.havajack.model.registration.SmzAccountDto
import com.hardcoders.havajack.service.SmzService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/client")
class ClientController(val smzService: SmzService, val clientService: ClientService)
 {
    @PostMapping("/new")
    fun new(@RequestBody account: SmzAccountDto): String {
        return clientService.createAccount(account)
    }

    @GetMapping("/info")
    fun getInfo(@RequestParam token: String): Client? {
        return clientService.getClient(token);
    }

    @PostMapping("/pay")
    fun payTaxes(@RequestParam token: String): String {
        return clientService.payTaxes(token);
    }
}