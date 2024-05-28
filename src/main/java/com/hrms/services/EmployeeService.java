package com.hrms.services;

import com.hrms.request.EmployeeRequest;
import com.hrms.response.EmployeeResponse;
import com.hrms.response.ServiceStatus;

import java.util.List;

public interface EmployeeService {
	ServiceStatus saveEmployee(EmployeeRequest employeeRequest);
    List<EmployeeResponse> getAllEmployees();
    ServiceStatus updateEmployee(int id, EmployeeRequest employeeRequest);
    ServiceStatus deleteEmployee(int id);  
    EmployeeResponse getEmployeeById(int id);
    EmployeeResponse getEmployeeByEmail(String emailId);
    EmployeeResponse getEmployeeByMobileNo(String mobileNo);
}
