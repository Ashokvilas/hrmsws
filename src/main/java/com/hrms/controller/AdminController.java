package com.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.pojos.Users;
import com.hrms.services.UserService;



@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/message")
	public String test() {
		return "Hello this is test api";
	}
	
	
	
	@GetMapping(value = "/getallusers", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Users> getAllUsers() {
	    return userService.getAllUsers();
	}
	
	
	@PostMapping(value = "/adduser",  consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String addUser(@RequestBody Users users) {
		return userService.upsert(users);
	    
	}
	
	@PostMapping(value = "/getuserbyid", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Users getUserById(@RequestBody Integer userid) {
		return userService.getUserById(userid);
	    
	}
	
	@PostMapping(value = "/deleteuser", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String deleteUserById(@RequestBody Integer userid) {
		return userService.deleteUserById(userid);
	    
	}

}