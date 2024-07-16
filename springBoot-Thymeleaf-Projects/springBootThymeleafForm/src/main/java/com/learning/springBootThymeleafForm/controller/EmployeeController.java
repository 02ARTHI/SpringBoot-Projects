package com.learning.springBootThymeleafForm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.learning.springBootThymeleafForm.model.Employee;
import com.learning.springBootThymeleafForm.service.EmployeeServiceImpl;

@Controller
public class EmployeeController {
 
	@Autowired
	private EmployeeServiceImpl service;
	
	@GetMapping("/")
	public String getall(Model map)
	{
		List<Employee> list = service.get();
		map.addAttribute("empList",list);
		return "index";
	}
	
	@GetMapping("/addnew")
	public String addnew(Model map)
	{
		Employee employee = new Employee();
		map.addAttribute("employee",employee);
		return "newemployee";
	}
	
	@PostMapping("/save")
	public String saveEmp(@ModelAttribute Employee employee, Model map)
	{
		service.save(employee);
		return"redirect:/";
	}
	
	@GetMapping("/update/{id}")
	public String updateEmp(@PathVariable("id") int id, Model map)
	{
		Employee emp = service.getById(id);
		map.addAttribute("employee",emp);
		return"newemployee";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable("id") int id)
	{
		service.deleteById(id);
		return"redirect:/";
	}
	
}
