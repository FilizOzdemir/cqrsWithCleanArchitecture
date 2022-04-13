package com.etiya.cqrsWithCleanArchitecture.application.course.commands.update;

import lombok.Data;

@Data
public class CourseUpdatedEvent {

    private String  courseId;
    private String courseName;
    private  int  totalHours;
}
