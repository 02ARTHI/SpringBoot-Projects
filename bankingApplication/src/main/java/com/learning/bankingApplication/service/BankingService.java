package com.learning.bankingApplication.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.bankingApplication.model.Account;
import com.learning.bankingApplication.repo.IBankingRepo;

@Service
public class BankingService {
	
	@Autowired
	private IBankingRepo repo;
	
	public Account createAccount(Account acc)
	{
		return repo.save(acc);
	
	}
	
	public Optional<Account> getAccounts(int id)
	{
		return repo.findById(id);
	}

}
