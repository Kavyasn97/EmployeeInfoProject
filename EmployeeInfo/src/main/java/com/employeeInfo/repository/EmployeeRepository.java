package com.employeeInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.employeeInfo.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
