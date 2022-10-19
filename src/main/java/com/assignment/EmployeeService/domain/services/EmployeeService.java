package com.assignment.EmployeeService.domain.services;

import com.assignment.EmployeeService.domain.entities.Employee;
import com.assignment.EmployeeService.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public void createEmployee(Employee employee) {
        Mono<Employee> savedEmp =  employeeRepository.save(employee);
        savedEmp.subscribe();
    }


}
