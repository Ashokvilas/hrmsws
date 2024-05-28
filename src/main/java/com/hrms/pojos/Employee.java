package com.hrms.pojos;

import java.util.Date;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "employees")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idemployees") // Map the id field to the idemployees column
    private int id;

    private String employeeName;
    private String emailId;
    private String mobileNo;
    private String firstName;
    private String middleName;
    private String employeeCode;
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
