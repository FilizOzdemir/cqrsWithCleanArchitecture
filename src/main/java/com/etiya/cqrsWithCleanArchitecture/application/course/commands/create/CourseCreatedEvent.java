package com.etiya.cqrsWithCleanArchitecture.application.course.commands.create;

import lombok.Data;

@Data
public class CourseCreatedEvent { //kurs oluşturma

    private String courseId;
    private String courseName;
    private  int  totalHours;
}
