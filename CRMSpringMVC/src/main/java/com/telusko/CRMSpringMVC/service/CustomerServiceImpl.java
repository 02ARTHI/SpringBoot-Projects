package com.telusko.CRMSpringMVC.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public void registerCustomer(Customer customer) {

       repo.save(customer);
		
	}

	@Override
	public Customer fetchCxById(int id) {
		
		 Optional<Customer> byId = repo.findById(id);
		 return byId.get();
	}

	@Override
	public void deleteCxById(int id) {
		repo.deleteById(id);
	}
	
	
}
