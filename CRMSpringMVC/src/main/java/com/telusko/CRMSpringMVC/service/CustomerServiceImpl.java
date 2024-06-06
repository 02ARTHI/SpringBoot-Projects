package com.telusko.CRMSpringMVC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.CRMSpringMVC.dao.ICustomerRepo;
import com.telusko.CRMSpringMVC.model.Customer;

@Service
public class CustomerServiceImpl implements ICustomerService {
 
	private ICustomerRepo repo;

	@Autowired
	public CustomerServiceImpl(ICustomerRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public List<Customer> getCxList() {
	
		return (List<Customer>) repo.findAll();
	}
	
	
}
