package com.telusko.TicketBookingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.TicketBookingApp.exception.TouristNotFoundException;
import com.telusko.TicketBookingApp.model.Tourist;
import com.telusko.TicketBookingApp.service.ITouristManagement;

@RestController
@RequestMapping("/api")
public class TouristController {
	
	@Autowired
	public ITouristManagement service;
	
	@PostMapping("/register")
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist)
	{
		
		String register = service.registerTourist(tourist);
		return new ResponseEntity<String>(register,HttpStatus.OK);
		
	}
	
	@GetMapping("/get")
	public ResponseEntity<?> getTourist() //?-> unknown type bcus return type can be more than one type
	{
		
		 List<Tourist> fetchallTourist = service.fetchallTourist();
		return new ResponseEntity<>(fetchallTourist,HttpStatus.OK);
		
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<?> findOneTourist(@PathVariable("id") int id) 
	{
		
		Tourist tourist = service.fetchTouristById(id);
		return new ResponseEntity<>(tourist,HttpStatus.OK);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateTourist(@RequestBody Tourist tourist) 
	{
		
		String msg= service.updateTourists(tourist);
		return new ResponseEntity<>(msg ,HttpStatus.OK);
		
	}
	
	@PatchMapping("/updatebudget/{id}/{budget}")
	public ResponseEntity<String> updateTourist(@PathVariable("id") int id,@PathVariable("budget") Double budget) 
	{
		
		String msg=service.updateTouristInfoByid(id, budget);
		return new ResponseEntity<>(msg ,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> updateTourist(@PathVariable("id") int id) 
	{
		
		String msg=service.deleteTouristById(id);
		return new ResponseEntity<>(msg ,HttpStatus.OK);
		
	}
	

	
}
