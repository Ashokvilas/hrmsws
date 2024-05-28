package com.hrms.controller;

import com.hrms.request.EmployeeRequest;
import com.hrms.response.EmployeeResponse;
import com.hrms.response.ServiceStatus;
import com.hrms.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/allemployees")
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {
        List<EmployeeResponse> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
   
    @PostMapping("/newemployee")
    public ResponseEntity<ServiceStatus> saveEmployee(@RequestBody EmployeeRequest employeeRequest) {
        ServiceStatus status = employeeService.saveEmployee(employeeRequest);
        return ResponseEntity.ok(status);
    }
   
    @PutMapping("/update")
    public ResponseEntity<ServiceStatus> updateEmployee(@RequestParam("id") int id, @RequestBody EmployeeRequest employeeRequest) {
        ServiceStatus status = employeeService.updateEmployee(id, employeeRequest);
        return ResponseEntity.ok(status);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<ServiceStatus> deleteEmployee(@RequestParam("id") int id) {
        ServiceStatus status = employeeService.deleteEmployee(id);
        return ResponseEntity.ok(status);
    }
    
    @GetMapping("/employee")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@RequestParam("id") int id) {
        EmployeeResponse employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    
    @GetMapping("/email")
    public ResponseEntity<EmployeeResponse> getEmployeeByEmail(@RequestParam("emailId") String emailId) {
        EmployeeResponse employee = employeeService.getEmployeeByEmail(emailId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("/mobile")
    public ResponseEntity<EmployeeResponse> getEmployeeByMobileNo(@RequestParam("mobileNo") String mobileNo) {
        EmployeeResponse employee = employeeService.getEmployeeByMobileNo(mobileNo);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
