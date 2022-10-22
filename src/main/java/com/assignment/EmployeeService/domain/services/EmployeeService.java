package com.assignment.EmployeeService.domain.services;

import com.assignment.EmployeeService.domain.entities.Employee;
import com.assignment.EmployeeService.domain.entities.Skill;
import com.assignment.EmployeeService.dtos.EmployeeDTO;
import com.assignment.EmployeeService.repository.EmployeeRepository;
import com.assignment.EmployeeService.repository.SkillRepository;
import com.assignment.EmployeeService.utils.EntityDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static com.assignment.EmployeeService.utils.EntityDtoUtil.toDto;
import static com.assignment.EmployeeService.utils.EntityDtoUtil.toEntity;

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

    public Mono<EmployeeDTO> createEmployee(EmployeeDTO employee) {
        return Mono.just(employee)
                .map(EntityDtoUtil::toEntity)
                .flatMap(employeeRepository::save)
                .map(EntityDtoUtil::toDto);

    }

    public Mono<Skill> createSkill(Skill skill) {
        Mono<Skill> savedSkill =  skillRepository.save(skill);
        savedSkill.subscribe();
        return savedSkill;
    }

    public Mono<EmployeeDTO> getEmployeeByID(int id) {
        return employeeRepository.findById(id).map(EntityDtoUtil::toDto);
    }


}
