package com.assignment.EmployeeService.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDTO {

    private int id;
    private String name;
    private String city;
    private String phone;
}
