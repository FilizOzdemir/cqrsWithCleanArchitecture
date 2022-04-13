package com.etiya.cqrsWithCleanArchitecture.ws.models;

import lombok.Data;

@Data
public class CreateCourseModel {

    private String courseName;
    private  int totalHours;
}
