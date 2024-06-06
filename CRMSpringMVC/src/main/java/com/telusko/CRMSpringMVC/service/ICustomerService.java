package com.telusko.CRMSpringMVC.service;

import java.util.List;

import com.telusko.CRMSpringMVC.model.Customer;

public interface ICustomerService {
	
	public List<Customer> getCxList();
	public void registerCustomer(Customer customer);
	public Customer fetchCxById(int id);
	public void deleteCxById(int id);

}
