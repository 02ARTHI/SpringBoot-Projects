package com.learning.bankingApplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data 
@Entity
public class Account {
   @Id
	public int id;
	public String AccHolderName;
	public Double balance;
	
}
