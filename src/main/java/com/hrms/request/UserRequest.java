[21:09] amar kumar
package com.hrms.request;
 
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;
 
import lombok.AllArgsConstructor;

import lombok.Data;

import lombok.NoArgsConstructor;
 
@Data

@AllArgsConstructor

@NoArgsConstructor

@Entity

public class UserRequest {

	 @Id

	    @GeneratedValue(strategy = GenerationType.IDENTITY)

	    private int id;

	private String username;

	private String password;

	private String phonenumber;

 
}

[21:10] amar kumar
package com.hrms.response;
 
public class ServiceStatus {
    private int statusCode;
    private String statusDescription;
 
    public ServiceStatus(int statusCode, String statusDescription) {
        this.statusCode = statusCode;
        this.statusDescription = statusDescription;
    }
 
    // Getters and Setters
    public int getStatusCode() {
        return statusCode;
    }
 
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
 
    public String getStatusDescription() {
        return statusDescription;
    }
 
    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }
}
 