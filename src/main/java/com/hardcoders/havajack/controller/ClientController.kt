package com.hardcoders.havajack.controller

import com.hardcoders.havajack.dto.TokenDto
import com.hardcoders.havajack.model.Client
import com.hardcoders.havajack.service.ClientService
import com.hardcoders.havajack.service.SmzService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/client")
class ClientController(val smzService: SmzService, val clientService: ClientService)
 {
//    @PostMapping("/new")
//    fun new(@RequestBody token: TokenDto): String {
//        return clientService.createClient(token.token)
//    }

    @GetMapping("/info")
    fun getInfo(@RequestParam token: String): Client? {
        return clientService.getClient(token)
    }

    @PostMapping("/pay")
    fun payTaxes(@RequestParam token: TokenDto): String {
        return clientService.payTaxes(token.token)
    }
}