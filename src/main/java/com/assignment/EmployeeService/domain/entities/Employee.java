package com.assignment.EmployeeService.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("emp")
@Data
@NoArgsConstructor
public class Employee {
    @PrimaryKey("emp_id")
    private int id;
    @Column("emp_name")
    private String name;
    @Column("emp_city")
    private String city;
    @Column("emp_phone")
    private String phone;

}
