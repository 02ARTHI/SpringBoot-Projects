package com.learning.bankingApplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Account {
   @Id
	private int id;
	private String AccHolderName;
	private Double balance;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccHolderName() {
		return AccHolderName;
	}
	public void setAccHolderName(String accHolderName) {
		AccHolderName = accHolderName;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}

	
	
}
