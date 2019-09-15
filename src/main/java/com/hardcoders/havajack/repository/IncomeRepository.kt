package com.hardcoders.havajack.repository

import com.hardcoders.havajack.model.Income
import org.springframework.data.jpa.repository.JpaRepository

interface IncomeRepository : JpaRepository<Income, Long>{
}