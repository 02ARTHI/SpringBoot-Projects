package com.telusko.TicketBookingApp.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public String updateTourists(Tourist tourist) {
		int id=tourist.getTid();
		Optional<Tourist> byId = repo.findById(id);
		if(byId.isPresent())
		{
			repo.save(tourist);
			return "tourist info with id "+id + " got updated";
		}
		else
		{
			throw new TouristNotFoundException("tourist with given id is not found");
		}
		
	}

	@Override
	public String updateTouristInfoByid(int id, Double budget) {
		Optional<Tourist> touristID=repo.findById(id);
		if(touristID.isPresent())
		{
			Tourist tourist = touristID.get();
			tourist.setBudget(budget);
			repo.save(tourist);
			return "tourist info with id "+id + " got updated";
			
		} 
		else
		{
			throw new TouristNotFoundException("tourist with given id is not found");
		}
		
		
		
	}

	@Override
	public String deleteTouristById(int id) {
		Optional<Tourist> optional = repo.findById(id);
		if(optional.isPresent())
		{
			repo.deleteById(id);
			return "tourist info with id "+id + " got deleted";
		}
		else
		{
			throw new TouristNotFoundException("tourist with given id is not found");
		}
		
		
	}

}
