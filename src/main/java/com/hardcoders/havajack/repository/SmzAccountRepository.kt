package com.hardcoders.havajack.repository

import com.hardcoders.havajack.model.SmzAccount
import org.springframework.data.jpa.repository.JpaRepository

public interface SmzAccountRepository : JpaRepository<SmzAccount, Long> {

}