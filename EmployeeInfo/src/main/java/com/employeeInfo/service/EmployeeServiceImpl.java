package com.employeeInfo.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employeeInfo.controller.EmployeeNotFoundException;
import com.employeeInfo.entity.Employee;
import com.employeeInfo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	 @Autowired
	 EmployeeRepository employeeRepository;
	   
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

   @Override
    public Employee getEmployeeById(Long id) {
       Optional<Employee> optionalEmployee = employeeRepository.findById(id);
       //return optionalEmployee.orElse(null);
       return optionalEmployee.orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found"));
    }
   
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();
            existingEmployee.setFirstName(updatedEmployee.getFirstName());
            existingEmployee.setLastName(updatedEmployee.getLastName());
            existingEmployee.setEmail(updatedEmployee.getEmail());
            return employeeRepository.save(existingEmployee);
        } else {
            return null;
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
    
    @Override
    public List<Employee> getAllEmployeesSortedByAge() {
        List<Employee> employees = employeeRepository.findAll();
        Comparator<Employee> ageComparator = Comparator.comparingInt(Employee::getAge);
        employees.sort(ageComparator);
        return employees;
    }
}
