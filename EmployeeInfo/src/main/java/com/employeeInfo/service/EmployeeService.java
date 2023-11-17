package com.employeeInfo.service;

import java.util.List;
import com.employeeInfo.controller.EmployeeNotFoundException;
import com.employeeInfo.entity.Employee;

public interface EmployeeService {

	    List<Employee> getAllEmployees();
	    List<Employee> getAllEmployeesSortedByAge();
	    Employee getEmployeeById(Long id)throws EmployeeNotFoundException;
	    Employee saveEmployee(Employee employee);
	    Employee updateEmployee(Long id, Employee employee);
	    void deleteEmployee(Long id);
}
