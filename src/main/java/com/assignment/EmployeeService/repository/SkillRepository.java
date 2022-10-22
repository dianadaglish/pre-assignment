package com.assignment.EmployeeService.repository;

import com.assignment.EmployeeService.domain.entities.Employee;
import com.assignment.EmployeeService.domain.entities.Skill;
import com.assignment.EmployeeService.domain.entities.SkillPK;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

public interface SkillRepository extends ReactiveCassandraRepository<Skill, SkillPK> {
}
