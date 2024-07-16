package com.learning.springBootThymeleafForm.service;

import java.util.List;

import com.learning.springBootThymeleafForm.model.Employee;

public interface IEmployeeSErvice {

	List<Employee> get();
	void save(Employee employee);
	void deleteById(int id);
	Employee getById(int id);
}
