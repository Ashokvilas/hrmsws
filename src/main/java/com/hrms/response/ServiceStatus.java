package com.hrms.response;

import lombok.*;

@Data
public class ServiceStatus {
    private int statusCode;
    private String statusDescription;

    public ServiceStatus(int statusCode, String statusDescription) {
        this.statusCode = statusCode;
        this.statusDescription = statusDescription;
    }

    
    
}
