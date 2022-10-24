package com.assignment.EmployeeService.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    @JsonProperty("emp_id")
    private int id;
    @JsonProperty("emp_name")
    private String name;
    @JsonProperty("emp_city")
    private String city;
    @JsonProperty("emp_phone")
    private String phone;
    @JsonProperty("java_exp")
    private double javaExperience;
    @JsonProperty("spring_ex")
    private double springExperience;

    @JsonInclude(Include.NON_NULL)
    private String status;
}
