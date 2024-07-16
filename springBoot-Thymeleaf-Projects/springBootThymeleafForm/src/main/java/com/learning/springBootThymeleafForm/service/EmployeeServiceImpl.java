package com.learning.springBootThymeleafForm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.springBootThymeleafForm.model.Employee;
import com.learning.springBootThymeleafForm.repo.IEmployeeRepo;

@Service
public class EmployeeServiceImpl implements IEmployeeSErvice {
	
	@Autowired
	private IEmployeeRepo repo;

	@Override
	public List<Employee> get() {
		
		return repo.findAll();
	}

	@Override
	public void save(Employee employee) {
		repo.save(employee);
		
	}

	@Override
	public void deleteById(int id) {
		repo.deleteById(id);
		
	}

	@Override
	public Employee getById(int id) {
		Optional<Employee> emp = repo.findById(null);
		Employee employee=null;
		if(emp.isPresent())
		{
			employee= emp.get();
		}
		else
		{
			throw new RuntimeException("employee not found for given id "+id);
		}
		return employee;
	}

}
