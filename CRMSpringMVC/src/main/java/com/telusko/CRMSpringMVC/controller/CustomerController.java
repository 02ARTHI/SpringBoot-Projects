package com.telusko.CRMSpringMVC.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/showForm")
	public String gerform(Map<String, Object> model)
	{
		Customer c = new Customer();
		model.put("customer",c);
		return"showForm";
		
	}
	
	@PostMapping("/registerCustomer")
	public String registercx(@ModelAttribute("customer") Customer customer,Map<String, Object> model)
	{
		service.registerCustomer(customer);
		return"redirect:/cxlist";
		
	}
	
	@GetMapping("/updateForm")
	public String updatecus(@RequestParam("customerId") int id,Map<String, Object> model)
	{
		Customer cx = service.fetchCxById(id);
		model.put("customer", cx);
		return"updateForm";
	}
	
	@GetMapping("/deleteData")
	public String deletcus(@RequestParam("customerId") int id)
	{
		service.deleteCxById(id);
		return"redirect:/cxlist";
	}
	
	
}
