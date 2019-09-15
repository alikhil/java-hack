package com.hardcoders.havajack.repository

import com.hardcoders.havajack.model.Client
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ClientRepository : JpaRepository<Client, Long>{

    fun findByInn(inn: String): Optional<Client>

}
