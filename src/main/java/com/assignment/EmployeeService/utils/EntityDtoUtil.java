package com.assignment.EmployeeService.utils;

import com.assignment.EmployeeService.domain.entities.Employee;
import com.assignment.EmployeeService.dtos.EmployeeDTO;
import org.springframework.beans.BeanUtils;

public class EntityDtoUtil {

    public static EmployeeDTO toDto(Employee emp) {
        EmployeeDTO dto = new EmployeeDTO();
        BeanUtils.copyProperties(emp, dto);
        return dto;
    }

    public static Employee toEntity(EmployeeDTO dto) {
        Employee emp = new Employee();
        BeanUtils.copyProperties(dto, emp);
        return emp;
    }
}
