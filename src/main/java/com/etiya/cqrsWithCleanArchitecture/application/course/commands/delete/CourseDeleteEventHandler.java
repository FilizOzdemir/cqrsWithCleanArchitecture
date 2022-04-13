package com.etiya.cqrsWithCleanArchitecture.application.course.commands.delete;

import com.etiya.cqrsWithCleanArchitecture.application.course.commands.create.CourseCreatedEvent;
import com.etiya.cqrsWithCleanArchitecture.domain.Course;
import com.etiya.cqrsWithCleanArchitecture.persistence.CourseRepository;
import com.etiya.cqrsWithCleanArchitecture.persistence.DeleteCourseRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseDeleteEventHandler {
    private DeleteCourseRepository deleteCourseRepository;

    @Autowired
    public CourseDeleteEventHandler(DeleteCourseRepository deleteCourseRepository) {
        this.deleteCourseRepository=deleteCourseRepository;
    }

    @EventHandler
    public void on(CourseDeletedEvent courseDeletedEvent){
        Course course = new Course();
        BeanUtils.copyProperties(courseDeletedEvent,course);
        this.deleteCourseRepository.delete(course);
    }
}
