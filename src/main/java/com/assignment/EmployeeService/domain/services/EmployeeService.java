package com.assignment.EmployeeService.domain.services;

import com.assignment.EmployeeService.domain.entities.Employee;
import com.assignment.EmployeeService.domain.entities.Skill;
import com.assignment.EmployeeService.repository.EmployeeRepository;
import com.assignment.EmployeeService.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    SkillRepository skillRepository;

    public Mono<Employee> createEmployee(Employee employee) {
        Mono<Employee> savedEmp =  employeeRepository.save(employee);
        savedEmp.subscribe();
        return savedEmp;
    }

    public Mono<Skill> createSkill(Skill skill) {
        Mono<Skill> savedSkill =  skillRepository.save(skill);
        savedSkill.subscribe();
        return savedSkill;
    }

    public Mono<Employee> getEmployeeByID(int id) {
        return employeeRepository.findById(id);
    }


}
