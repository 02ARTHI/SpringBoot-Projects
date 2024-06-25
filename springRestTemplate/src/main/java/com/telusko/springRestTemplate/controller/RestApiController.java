package com.telusko.springRestTemplate.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.springRestTemplate.model.UserData;

@RestController
@RequestMapping(path="/RestApi" , produces="application/json")
@CrossOrigin(origins = "*")
public class RestApiController {

	@GetMapping("/getData")
	public UserData get()
	{
		UserData data = new UserData();
		data.setData("aws");
		data.setId("01");
		data.setUserName("arthi");
		return data;
	}
	
	@PostMapping
	public ResponseEntity<UserData> produce(@RequestBody UserData user)
	{
		HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(user, headers,
                                    HttpStatus.CREATED);
	}
}
