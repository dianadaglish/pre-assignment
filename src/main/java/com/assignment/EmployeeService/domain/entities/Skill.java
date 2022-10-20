package com.assignment.EmployeeService.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("emp_skill")
public class Skill {
    @PrimaryKey("emp_id")
    private int employeeId;
    @PrimaryKey("java_exp")
    private double javaExp;
    @PrimaryKey("spring_exp")
    private double springExp;

}
