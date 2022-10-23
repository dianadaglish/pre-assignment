package com.assignment.EmployeeService.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private int id;
    private String name;
    private String city;
    private String phone;
    private double javaExperience;
    private double springExperience;
    private String status;
}
