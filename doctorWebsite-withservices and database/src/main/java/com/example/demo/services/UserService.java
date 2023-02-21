package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.models.AppUser;
import com.example.demo.repositories.UserRespository;


// Services in Spring:
// dedicated to handling logic
// available to be injected anywhere
// as pure Java as possible ( no much of annotation which is dense on Spring)
@Service
public class UserService {
	
	private Long nextUserId = 0L;
	private final ArrayList<AppUser> users = new ArrayList<>();
	
	public AppUser getByUsernameAndPassword(String username, String password ) {
		
		for(AppUser user : users) {
			if (user.username.equals(username) && user.password.equals(password)) {
				//return user
				return user;
		}
	}
		return null;
		
	}
	
	public void register(AppUser user) throws Exception {
		for(AppUser existingUser : users) {
			if(user.username.equals(existingUser.username)) {
				//new object will created in the new Exception and will be stored in e variable
				//here we throwing a generic exception that has nothing to do with http, in the controller we indicate the exception through an HTTP status code
				throw new Exception();
			}
		}
		user.id = nextUserId++;
		users.add(user);}

}













