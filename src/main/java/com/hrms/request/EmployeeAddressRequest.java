package com.hrms.request;

public class EmployeeAddressRequest {

    private int typeOfAddress;
    private String address;
    private String landmark;
    private int country;
    private int stateId;
    private int cityId;
    private int zipcode;
    private int employeeId;
	public int getTypeOfAddress() {
		return typeOfAddress;
	}
	public void setTypeOfAddress(int typeOfAddress) {
		this.typeOfAddress = typeOfAddress;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public int getCountry() {
		return country;
	}
	public void setCountry(int country) {
		this.country = country;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

    
}
