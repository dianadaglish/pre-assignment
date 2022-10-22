package com.assignment.EmployeeService.repository;

import com.assignment.EmployeeService.domain.entities.Employee;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import reactor.core.publisher.Mono;

public interface EmployeeRepository extends ReactiveCassandraRepository<Employee, Integer> {

    public Mono<Employee> findById(final int empId);

}
