package com.assignment.EmployeeService.controllers;

import com.assignment.EmployeeService.domain.entities.Employee;
import com.assignment.EmployeeService.domain.entities.Skill;
import com.assignment.EmployeeService.domain.services.EmployeeService;
import com.assignment.EmployeeService.dtos.EmployeeDTO;
import com.assignment.EmployeeService.dtos.SkillDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Mono<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
       return employeeService.createEmployee(employeeDTO);
    }

    @PostMapping(value = "/findEmpSkillset", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ResponseEntity<EmployeeDTO>> findEmpSkills(@RequestBody SkillDTO skill) {
        return null;
    }
}
