package com.assignment.EmployeeService.repository;

import com.assignment.EmployeeService.domain.entities.Skill;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface SkillRepository extends ReactiveCassandraRepository<Skill, Integer> {
    @AllowFiltering
    Flux<Skill> findByJavaExperienceGreaterThan(final double javaExperience);

}
