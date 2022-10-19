package com.assignment.EmployeeService.repository;

import com.assignment.EmployeeService.domain.entities.Employee;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

public interface EmployeeRepository extends ReactiveCassandraRepository<Employee, Integer> {

}
