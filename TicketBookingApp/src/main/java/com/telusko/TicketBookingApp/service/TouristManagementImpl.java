package com.telusko.TicketBookingApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.TicketBookingApp.dao.ITouristRepo;
import com.telusko.TicketBookingApp.exception.TouristNotFoundException;
import com.telusko.TicketBookingApp.model.Tourist;

@Service
public class TouristManagementImpl implements ITouristManagement {

	@Autowired
	private ITouristRepo repo;
	
	@Override
	public String registerTourist(Tourist tourist) {
		System.out.println("inside repo impl");
		Integer id = repo.save(tourist).getTid();
		System.out.println(repo.save(tourist).getTid());
		return "tourist info saved with id "+ id;
	}

	@Override
	public List<Tourist> fetchallTourist() {
		
		return repo.findAll();
	}

	@Override
	public Tourist fetchTouristById(int id) {
		
		return repo.findById(id).orElseThrow(()-> new TouristNotFoundException("Tourist with given id "+ id+ " not found"));
	}

}
