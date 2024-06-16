package com.telusko.TicketBookingApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tourist {
  
	
	@Id
	private int tid;
	private String name;
	private String city;
	private String packageType;
	private Double budget;
	
	
	public Tourist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tourist(int tid, String name, String city, String packageType, Double budget) {
		super();
		this.tid = tid;
		this.name = name;
		this.city = city;
		this.packageType = packageType;
		this.budget = budget;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPackageType() {
		return packageType;
	}
	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}
	public Double getBudget() {
		return budget;
	}
	public void setBudget(Double budget) {
		this.budget = budget;
	}
	@Override
	public String toString() {
		return "Tourist [tid=" + tid + ", name=" + name + ", city=" + city + ", packageType=" + packageType
				+ ", budget=" + budget + "]";
	}
	
	
}
