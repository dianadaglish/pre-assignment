package com.assignment.EmployeeService.controllers;

import com.assignment.EmployeeService.domain.entities.Employee;
import com.assignment.EmployeeService.domain.services.EmployeeService;
import com.assignment.EmployeeService.dtos.EmployeeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class EmployeeController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    EmployeeService employeeService;

    @PostMapping(value = "/createEmployee", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Employee> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
         employeeService.createEmployee(employee);
        return null;
    }
}
