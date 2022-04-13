package com.etiya.cqrsWithCleanArchitecture.application.course.commands.update;

import com.etiya.cqrsWithCleanArchitecture.application.course.commands.create.CourseCreatedEvent;
import com.etiya.cqrsWithCleanArchitecture.domain.Course;
import com.etiya.cqrsWithCleanArchitecture.persistence.UpdateCourseRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CourseUpdateEventHandler {
    private UpdateCourseRepository updateCourseRepository;

    public CourseUpdateEventHandler(UpdateCourseRepository updateCourseRepository) {
        this.updateCourseRepository = updateCourseRepository;
    }

    @EventHandler
    public void on(CourseUpdatedEvent courseUpdatedEvent){

        Course course = new Course();
        BeanUtils.copyProperties(courseUpdatedEvent,course);
        this.updateCourseRepository.save(course);
    }
}
