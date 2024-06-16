package com.telusko.TicketBookingApp.service;

import java.util.List;

import com.telusko.TicketBookingApp.model.Tourist;

public interface ITouristManagement {
    
	public String registerTourist(Tourist tourist);
	public List<Tourist> fetchallTourist();
	public Tourist fetchTouristById(int id);
	public String updateTourists(Tourist tourist);
	public String updateTouristInfoByid(int id,Double budget);
	public String deleteTouristById(int id);
}
