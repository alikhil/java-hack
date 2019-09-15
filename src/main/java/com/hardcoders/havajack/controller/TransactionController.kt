package com.hardcoders.havajack.controller

import com.hardcoders.havajack.model.TransactionForm
import com.hardcoders.havajack.repository.ClientRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/transactions")
class TransactionController(val clientsRepository: ClientRepository) {


    @PostMapping("/new")
    fun new(@RequestBody newTransaction: TransactionForm): String {
        val clientO = clientsRepository.findByInn(newTransaction.toUser)
        if (!clientO.isPresent) {
            return "user receiving - not found"
        }
        val client = clientO.get()
        client.availableAmount += newTransaction.amount * (100 - client.tax)
        client.lockedAmount += newTransaction.amount * client.tax

        clientsRepository.save(client)
        return "ok"
    }
}