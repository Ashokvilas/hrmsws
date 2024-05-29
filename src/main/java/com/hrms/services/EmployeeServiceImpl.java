package com.hrms.services;

import com.hrms.pojos.Employee;
import com.hrms.pojos.Status;
import com.hrms.pojos.Users;
import com.hrms.repository.EmployeeRepository;
import com.hrms.repository.UserRepository;
import com.hrms.repository.StatusRepository;
import com.hrms.request.EmployeeRequest;
import com.hrms.response.EmployeeResponse;
import com.hrms.response.ServiceStatus;
import com.hrms.utilities.EmployeeConverter;
import com.hrms.config.OrganizationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private OrganizationConfig organizationConfig;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(EmployeeConverter::toEmployeeResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ServiceStatus saveEmployee(EmployeeRequest employeeRequest) {
        if (employeeRepository.existsByEmailId(employeeRequest.getEmailId())) {
            throw new RuntimeException("Email already exists");
        }

        if (employeeRepository.existsByMobileNo(employeeRequest.getMobileNo())) {
            throw new RuntimeException("Phone number already exists");
        }

        if (employeeRequest.getAlternativeNumber() != null &&
                employeeRepository.existsByAlternativeNumber(employeeRequest.getAlternativeNumber())) {
            throw new RuntimeException("Alternate mobile number already exists");
        }

        Employee employee = EmployeeConverter.fromEmployeeRequest(employeeRequest);
        employee.setEmployeeCode(generateEmployeeCode());
        employee.setStatusId(6);
        employee = employeeRepository.save(employee);

        
        Users user = new Users();
        user.setUsername(employee.getEmailId());
        user.setPassword(generateTemporaryPassword());
        user.setMobileno(employee.getMobileNo());
        user.setEmployeecode(employee.getEmployeeCode());
        user.setStatus(getStatusNameById(employee.getStatusId())); // Initial status is set to Active
        userRepository.save(user);

        return new ServiceStatus(200, "Employee saved successfully");
    }


    @Override
    public ServiceStatus updateEmployee(int id, EmployeeRequest employeeRequest) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        if (!existingEmployee.getEmailId().equals(employeeRequest.getEmailId()) &&
                employeeRepository.existsByEmailId(employeeRequest.getEmailId())) {
            throw new RuntimeException("Email already exists");
        }

        if (!existingEmployee.getMobileNo().equals(employeeRequest.getMobileNo()) &&
                employeeRepository.existsByMobileNo(employeeRequest.getMobileNo())) {
            throw new RuntimeException("Phone number already exists");
        }

        if (employeeRequest.getAlternativeNumber() != null &&
                !existingEmployee.getAlternativeNumber().equals(employeeRequest.getAlternativeNumber()) &&
                employeeRepository.existsByAlternativeNumber(employeeRequest.getAlternativeNumber())) {
            throw new RuntimeException("Alternate mobile number already exists");
        }

        Employee updatedEmployee = EmployeeConverter.fromEmployeeRequest(employeeRequest);
        updatedEmployee.setId(id);
        updatedEmployee.setEmployeeCode(existingEmployee.getEmployeeCode());

       
        if (employeeRequest.getStatusId() != 0) {
            updatedEmployee.setStatusId(employeeRequest.getStatusId());
        }

        updatedEmployee = employeeRepository.save(updatedEmployee);

        
        updateUserRecord(updatedEmployee);

        return new ServiceStatus(200, "Employee updated successfully");
    }

    @Transactional
    @Override
    public ServiceStatus deleteEmployee(int id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        
        logger.info("Deleting employee: {}", employee);

       
        userRepository.deleteByUsername(employee.getEmailId());

      
        employeeRepository.deleteById(id);

        
        logger.info("Employee deleted successfully");

        return new ServiceStatus(200, "Employee deleted successfully");
    }


    @Override
    public EmployeeResponse getEmployeeById(int id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        return EmployeeConverter.toEmployeeResponse(employee);
    }

    @Override
    public EmployeeResponse getEmployeeByEmail(String emailId) {
        Employee employee = employeeRepository.findByEmailId(emailId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        return EmployeeConverter.toEmployeeResponse(employee);
    }

    @Override
    public EmployeeResponse getEmployeeByMobileNo(String mobileNo) {
        Employee employee = employeeRepository.findByMobileNo(mobileNo)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        return EmployeeConverter.toEmployeeResponse(employee);
    }

    private String generateTemporaryPassword() {
        
        int length = 6;

        
        String charset = "0123456789";

        
        StringBuilder sb = new StringBuilder();

        
        Random random = new Random();

        
        for (int i = 0; i < length; i++) {
           
            int index = random.nextInt(charset.length());

            
            sb.append(charset.charAt(index));
        }

        
        return sb.toString();
    }

    private String generateEmployeeCode() {
        Optional<Employee> maxEmployeeOptional = employeeRepository.findTopByOrderByEmployeeCodeDesc();
        String maxEmployeeCode = maxEmployeeOptional.map(Employee::getEmployeeCode).orElse(null);

        int nextEmployeeNumber = organizationConfig.getStartingEmployeeCode();

        if (maxEmployeeCode != null) {
            String numericPart = maxEmployeeCode.substring(3);
            nextEmployeeNumber = Integer.parseInt(numericPart) + 1;
        }

        logger.info("Max Employee Code: {}", maxEmployeeCode);
        logger.info("Next Employee Number: {}", nextEmployeeNumber);

        return organizationConfig.getOrganizationName().substring(0, 3).toLowerCase() + nextEmployeeNumber;
    }

    private void updateUserRecord(Employee employee) {
        Users user = userRepository.findByUsername(employee.getEmailId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setMobileno(employee.getMobileNo());
        user.setEmployeecode(employee.getEmployeeCode());
        user.setStatus(getStatusNameById(employee.getStatusId())); // Fetch status name by ID

        userRepository.save(user);
    }

    private String getStatusNameById(int statusId) {
        Optional<Status> statusOptional = statusRepository.findById(statusId);
        if(statusOptional.isPresent()) {
            return statusOptional.get().getStatusname();
        } else {
            throw new RuntimeException("Invalid status ID");
        }
    }
}
