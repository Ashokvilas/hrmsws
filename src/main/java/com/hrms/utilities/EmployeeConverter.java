package com.hrms.utilities;

import com.hrms.pojos.Employee;
import com.hrms.request.EmployeeRequest;
import com.hrms.response.EmployeeResponse;

public class EmployeeConverter {

    public static Employee fromEmployeeRequest(EmployeeRequest request) {
        Employee employee = new Employee();
        if (request.getEmployeeName() != null) {
            employee.setEmployeeName(request.getEmployeeName());
        }
        if (request.getEmailId() != null) {
            employee.setEmailId(request.getEmailId());
        }
        if (request.getMobileNo() != null) {
            employee.setMobileNo(request.getMobileNo());
        }
        if (request.getFirstName() != null) {
            employee.setFirstName(request.getFirstName());
        }
        if (request.getMiddleName() != null) {
            employee.setMiddleName(request.getMiddleName());
        }
        if (request.getDateOfBirth() != null) {
            employee.setDateOfBirth(request.getDateOfBirth());
        }
        if (request.getNationality() != null) {
            employee.setNationality(request.getNationality());
        }
        if (request.getGenderTypeId() != 0) {
            employee.setGenderTypeId(request.getGenderTypeId());
        }
        if (request.getMaritalStatusId() != 0) {
            employee.setMaritalStatusId(request.getMaritalStatusId());
        }
        if (request.getDesignationId() != 0) {
            employee.setDesignationId(request.getDesignationId());
        }
        if (request.getDepartmentId() != 0) {
            employee.setDepartmentId(request.getDepartmentId());
        }
        
        if (request.getCityId() != 0) {
            employee.setCityId(request.getCityId());
        }
        if (request.getStateId() != 0) {
            employee.setStateId(request.getStateId());
        }
        if (request.getCountryId() != 0) {
            employee.setCountryId(request.getCountryId());
        }
        if (request.getAlternativeNumber() != null) {
            employee.setAlternativeNumber(request.getAlternativeNumber());
        }
        return employee;
    }

    public static EmployeeResponse toEmployeeResponse(Employee employee) {
        EmployeeResponse response = new EmployeeResponse();
        response.setId(employee.getId());
        if (employee.getEmployeeName() != null) {
            response.setEmployeeName(employee.getEmployeeName());
        }
        if (employee.getEmailId() != null) {
            response.setEmailId(employee.getEmailId());
        }
        if (employee.getMobileNo() != null) {
            response.setMobileNo(employee.getMobileNo());
        }
        if (employee.getFirstName() != null) {
            response.setFirstName(employee.getFirstName());
        }
        if (employee.getMiddleName() != null) {
            response.setMiddleName(employee.getMiddleName());
        }
        if (employee.getEmployeeCode() != null) {
            response.setEmployeeCode(employee.getEmployeeCode());
        }
        if (employee.getDateOfBirth() != null) {
            response.setDateOfBirth(employee.getDateOfBirth());
        }
        if (employee.getNationality() != null) {
            response.setNationality(employee.getNationality());
        }
        if (employee.getGenderTypeId() != 0) {
            response.setGenderTypeId(employee.getGenderTypeId());
        }
        if (employee.getMaritalStatusId() != 0) {
            response.setMaritalStatusId(employee.getMaritalStatusId());
        }
        if (employee.getDesignationId() != 0) {
            response.setDesignationId(employee.getDesignationId());
        }
        if (employee.getDepartmentId() != 0) {
            response.setDepartmentId(employee.getDepartmentId());
        }
        if (employee.getStatusId() != 0) {
            response.setStatusId(employee.getStatusId());
        }
        if (employee.getCityId() != 0) {
            response.setCityId(employee.getCityId());
        }
        if (employee.getStateId() != 0) {
            response.setStateId(employee.getStateId());
        }
        if (employee.getCountryId() != 0) {
            response.setCountryId(employee.getCountryId());
        }
        if (employee.getAlternativeNumber() != null) {
            response.setAlternativeNumber(employee.getAlternativeNumber());
        }
        return response;
    }
}
