package com.hardcoders.havajack.repository

import com.hardcoders.havajack.model.SmzAccount
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SmzAccountRepository : JpaRepository<SmzAccount, Long> {

}