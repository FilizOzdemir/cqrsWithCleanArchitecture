package com.etiya.cqrsWithCleanArchitecture.application.course.commands.create;

import lombok.Data;

@Data
public class CourseCreatedEvent {

    private String courseId;
    private String courseName;
    private  int  totalHours;
}
