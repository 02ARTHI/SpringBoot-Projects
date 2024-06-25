package com.telusko.springRestTemplate.model;

import lombok.Data;

@Data
public class UserData {

	public String id;
    public String userName;
    public String data;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public UserData(String id, String userName, String data) {
		super();
		this.id = id;
		this.userName = userName;
		this.data = data;
	}
	public UserData() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserData [id=" + id + ", userName=" + userName + ", data=" + data + "]";
	}
    
    
}
