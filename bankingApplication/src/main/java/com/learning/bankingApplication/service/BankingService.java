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
	
	public Account deposit(int id,Double amount)
	{
		Account acc = getAccounts(id).orElseThrow(()-> new RuntimeException("Account with given id not found"));
		acc.setBalance(acc.getBalance()+amount);
		return repo.save(acc);
	}
	
	public Account withdraw(int id, Double amount)
	{
		Account acc = getAccounts(id).orElseThrow(()-> new RuntimeException("Account with given id not found"));
		if(acc.getBalance()<amount)
		{
			throw new RuntimeException("insufficient balance");
		}
		
		acc.setBalance(acc.getBalance()-amount);
		return repo.save(acc);
	}

}
