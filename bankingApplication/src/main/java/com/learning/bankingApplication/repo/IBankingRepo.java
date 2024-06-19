package com.learning.bankingApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.bankingApplication.model.Account;

@Repository
public interface IBankingRepo extends JpaRepository<Account, Integer> {

}
