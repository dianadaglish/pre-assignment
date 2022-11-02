package com.assignment.EmployeeService.domain.services;

import com.assignment.EmployeeService.domain.entities.Employee;
import com.assignment.EmployeeService.domain.entities.Skill;
import com.assignment.EmployeeService.dtos.EmployeeDTO;
import com.assignment.EmployeeService.repository.EmployeeRepository;
import com.assignment.EmployeeService.repository.SkillRepository;
import com.assignment.EmployeeService.utils.EntityDtoUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static com.assignment.EmployeeService.utils.EntityDtoUtil.*;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    SkillRepository skillRepository;


    public Mono<EmployeeDTO> createEmployee(EmployeeDTO employee) {
        EmployeeDTO empResponse;
        return employeeRepository.existsById(employee.getId())
                .flatMap(empExists -> {
                    EmployeeDTO response = new EmployeeDTO();
                    Employee empEntity = toEmployeeEntity(employee);
                    Skill skill = toSkillEntity(employee);
                    if (empExists) {
                        response.setStatus("ALREADY_EXISTS");
                    } else {
                        response.setStatus("CREATED");
                    }
                    Mono<Employee> monoEmp =  employeeRepository.save(empEntity);
                    Mono<Skill> monoSkill = skillRepository.save(skill);
                    return Mono.zip(monoEmp, monoSkill, Mono.just(response));})
                .flatMap(result -> {
                    EmployeeDTO empDto = result.getT3();
                    BeanUtils.copyProperties(result.getT1(), empDto);
                    BeanUtils.copyProperties(result.getT2(), empDto);
                    return Mono.just(empDto);}

                );

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
