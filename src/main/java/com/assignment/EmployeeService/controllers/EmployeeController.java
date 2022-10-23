package com.assignment.EmployeeService.controllers;

import com.assignment.EmployeeService.domain.services.EmployeeService;
import com.assignment.EmployeeService.dtos.EmployeeDTO;
import com.assignment.EmployeeService.dtos.ExperienceDTO;
import com.assignment.EmployeeService.kafka.KafkaProducer;
import com.assignment.EmployeeService.repository.EmployeeRepository;
import com.assignment.EmployeeService.repository.SkillRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EmployeeController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    SkillRepository skillRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    KafkaProducer messageProducer;


    @PostMapping(value = "/createEmployee", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Mono<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
       return employeeService.createEmployee(employeeDTO).doOnSuccess(p -> {messageProducer.sendMessage("test");});
    }

    @GetMapping(value = "/findEmpSkillset", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Flux<EmployeeDTO> findEmpSkills(@RequestBody ExperienceDTO skill) {
        skillRepository.findByKeyJavaExperience(skill.getJavaExperience())
                .flatMap(p -> {});
        return null;
    }
}
