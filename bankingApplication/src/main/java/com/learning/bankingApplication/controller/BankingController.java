package com.learning.bankingApplication.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.bankingApplication.model.Account;
import com.learning.bankingApplication.service.BankingService;

@RestController
@RequestMapping("/api/accounts")
public class BankingController {

	 @Autowired
	 private BankingService service;
	 
	 @PostMapping
	 public Account createAcc(@RequestBody Account acc)
	 {
		 return service.createAccount(acc);
	 }
	 
	 @GetMapping("/get/{id}")
	 public Account getacc(@PathVariable int id)
	 {
		 return service.getAccounts(id).orElseThrow(() -> new RuntimeException("Account not found for this given id"));
	 }
	 
	 @PostMapping("/deposit/{id}/name")
	 public Account deposit(@PathVariable int id, @RequestBody Map<String,Double> request)
	 {
		 Double amount = request.get("amount");
		 return service.deposit(id, amount);
	 }
	 
	 @PostMapping("/withdraw/{id}/name")
	 public Account withdraw(@PathVariable int id, @RequestBody Map<String,Double> request)
	 {
		 Double amount = request.get("amount");
		 return service.withdraw(id, amount);
	 }
}
