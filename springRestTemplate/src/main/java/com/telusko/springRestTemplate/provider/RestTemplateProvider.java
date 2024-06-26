package com.telusko.springRestTemplate.provider;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.telusko.springRestTemplate.model.UserData;

public class RestTemplateProvider {

	 RestTemplate rest = new RestTemplate();
	 
	 public UserData get()
	 {
		 return rest.getForObject("http://localhost:8090/RestApi/getData", UserData.class);
	 }
	 
	 public ResponseEntity<UserData> post(UserData user)
	 {
		 return rest.postForEntity("http://localhost:8090/RestApi", user, UserData.class);
	 }
	 
}
