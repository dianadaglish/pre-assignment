package com.assignment.EmployeeService.repository;

import com.assignment.EmployeeService.domain.entities.Employee;
import com.assignment.EmployeeService.domain.entities.Skill;
import com.assignment.EmployeeService.domain.entities.SkillPK;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface SkillRepository extends ReactiveCassandraRepository<Skill, SkillPK> {
    @AllowFiltering
    Flux<Skill> findBySkillPKJavaExperienceGreaterThan(final double javaExperience);

}
