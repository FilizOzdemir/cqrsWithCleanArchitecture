package com.etiya.cqrsWithCleanArchitecture.persistence;

import com.etiya.cqrsWithCleanArchitecture.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,String> {

    boolean existsCourseByCourseName(String name);
}
