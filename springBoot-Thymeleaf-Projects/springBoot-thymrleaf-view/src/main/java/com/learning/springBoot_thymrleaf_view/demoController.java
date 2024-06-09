package com.learning.springBoot_thymrleaf_view;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class demoController {
 
	@GetMapping("/")
	public String index()
	{
		return "index";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)    
	public ModelAndView get(@ModelAttribute("user") user user)
	
	{
		System.out.println("control in");
		ModelAndView modelAndView = new ModelAndView();  
		modelAndView.setViewName("user-data");        
		modelAndView.addObject("user", user);      
		return modelAndView;   
	}
}
