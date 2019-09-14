package com.hardcoders.havajack.repository;

import com.hardcoders.havajack.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<Account, Long> {

    @Query
    Account findByPhone(String phone);
}
