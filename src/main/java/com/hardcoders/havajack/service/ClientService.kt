package com.hardcoders.havajack.service

import com.hardcoders.havajack.model.Account
import com.hardcoders.havajack.model.Client

public interface ClientService {

    fun createClient(account: Account): Client

    fun getClient(token: String): Client

    fun payTaxes(token: String): String

}