package com.telusko.CRMSpringMVC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.telusko.CRMSpringMVC.model.Customer;
import com.telusko.CRMSpringMVC.service.ICustomerService;


@Controller
public class CustomerController {
 
	public ICustomerService service;

	@Autowired
	public CustomerController(ICustomerService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/cxlist")
	public String getCustomerdata(Model model)
	{
		List<Customer> customerList = service.getCxList();
		 model.addAttribute("customers",customerList);
		 customerList.forEach(c->System.out.println(c));
		return "customerList"; //lvn
	}
	
	
}
