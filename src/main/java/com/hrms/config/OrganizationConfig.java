package com.hrms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrganizationConfig {

    @Value("${organization.name}")
    private String organizationName;

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }
    @Value("${employee.starting.code}")
    private int startingEmployeeCode;

    

    public void setStartingEmployeeCode(int startingEmployeeCode) {
		this.startingEmployeeCode = startingEmployeeCode;
	}

	public int getStartingEmployeeCode() {
        return startingEmployeeCode;
}
}
