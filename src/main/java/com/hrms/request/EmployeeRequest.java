package com.hrms.request;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {

    private int id;
    private String employeeName;
    private String emailId;
    private String mobileNo;
    private String firstName;
    private String middleName;
    private Date dateOfBirth;
    private String nationality;
    private int genderTypeId;
    private int maritalStatusId;
    private int designationId;
    private int departmentId;
    private int statusId;
    
	private int cityId;
    private int stateId;
    private int countryId;
    private String alternativeNumber;
	
}
