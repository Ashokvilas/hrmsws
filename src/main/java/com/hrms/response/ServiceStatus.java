package com.hrms.response;
<<<<<<< HEAD

import lombok.*;

@Data
=======
 
>>>>>>> 7b60078b0f5fc990d76de059df4136f6a78726ef
public class ServiceStatus {
    private int statusCode;
    private String statusDescription;
 
    public ServiceStatus(int statusCode, String statusDescription) {
        this.statusCode = statusCode;
        this.statusDescription = statusDescription;
    }
<<<<<<< HEAD

    
    
}
=======
 
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
>>>>>>> 7b60078b0f5fc990d76de059df4136f6a78726ef
