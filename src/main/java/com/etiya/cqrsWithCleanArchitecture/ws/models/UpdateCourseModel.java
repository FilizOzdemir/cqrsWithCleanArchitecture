package com.etiya.cqrsWithCleanArchitecture.ws.models;

import lombok.Data;

@Data
public class UpdateCourseModel {

    private String courseId;
    private String courseName;
    private  int totalHours;
}
