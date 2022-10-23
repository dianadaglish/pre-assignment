package com.assignment.EmployeeService.repository;

import com.assignment.EmployeeService.domain.entities.Employee;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface EmployeeRepository extends ReactiveCassandraRepository<Employee, Integer> {

    public Mono<Employee> findById(final int empId);

}
