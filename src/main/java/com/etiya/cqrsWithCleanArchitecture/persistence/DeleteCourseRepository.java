package com.etiya.cqrsWithCleanArchitecture.persistence;

import com.etiya.cqrsWithCleanArchitecture.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeleteCourseRepository extends JpaRepository<Course,String> {
}
