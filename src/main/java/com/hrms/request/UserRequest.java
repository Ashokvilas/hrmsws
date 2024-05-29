package com.hrms.request;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.*;

@Data
public class UserRequest {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	private String username;
	private String password;
	private String phonenumber;
	
	

}
