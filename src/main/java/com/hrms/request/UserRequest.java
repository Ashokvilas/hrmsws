package com.hrms.request;

import javax.persistence.Entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserRequest {
	
	private String username;
	private String password;
	private String phonenumber;
	
	

}
