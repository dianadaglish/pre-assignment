package com.assignment.EmployeeService.utils;

import com.assignment.EmployeeService.domain.entities.Employee;
import com.assignment.EmployeeService.domain.entities.Skill;
import com.assignment.EmployeeService.domain.entities.SkillPK;
import com.assignment.EmployeeService.dtos.EmployeeDTO;
import org.springframework.beans.BeanUtils;

public class EntityDtoUtil {

    public static EmployeeDTO toDto(Employee emp, String status) {
        EmployeeDTO dto = new EmployeeDTO();
        BeanUtils.copyProperties(emp, dto);
        dto.setStatus(status);
        return dto;
    }

    public static EmployeeDTO toDto(Employee emp) {
        EmployeeDTO dto = new EmployeeDTO();
        BeanUtils.copyProperties(emp, dto);
        return dto;
    }

    public static Employee toEmployeeEntity(EmployeeDTO dto) {
        Employee emp = new Employee();
        BeanUtils.copyProperties(dto, emp);
        return emp;
    }

    public static Skill toSkillEntity(EmployeeDTO dto) {
        SkillPK pk = new SkillPK();
        Skill skill = new Skill();
        BeanUtils.copyProperties(dto, pk);
        skill.setSkillPK(pk);
        return skill;
    }

}
