package com.hrms.request;



import java.util.Date;

public class PreviousCompanyDetailsRequest {
    private String nameofthecompany;
    private Date startdate;
    private Date enddate;
    private int experieance;
    private String designation;
    private int employeeId;
	public String getNameofthecompany() {
		return nameofthecompany;
	}
	public void setNameofthecompany(String nameofthecompany) {
		this.nameofthecompany = nameofthecompany;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public int getExperieance() {
		return experieance;
	}
	public void setExperieance(int experieance) {
		this.experieance = experieance;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

    
}
