package com.hrms.repository;

import com.hrms.pojos.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findTopByOrderByEmployeeCodeDesc();
    boolean existsByEmailId(String emailId);
    boolean existsByMobileNo(String mobileNo);
    boolean existsByAlternativeNumber(String alternativeNumber);
    Optional<Employee> findByEmailId(String emailId);
    Optional<Employee> findByMobileNo(String mobileNo);

}
