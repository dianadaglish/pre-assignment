package com.assignment.EmployeeService.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;

import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.PARTITIONED;

@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyClass
public class SkillPK implements Serializable {

        @PrimaryKeyColumn(name = "emp_id", type = PARTITIONED)
        private int id;

        @PrimaryKeyColumn(name = "java_exp")
        private double javaExperience;

        @PrimaryKeyColumn(name = "spring_exp")
        private double springExperience;

}
