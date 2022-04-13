package com.etiya.cqrsWithCleanArchitecture.application.course.commands.delete;

import lombok.Data;

@Data
public class CourseDeletedEvent {
    private String courseId;
}
