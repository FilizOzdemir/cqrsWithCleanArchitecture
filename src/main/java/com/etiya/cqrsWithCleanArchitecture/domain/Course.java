package com.etiya.cqrsWithCleanArchitecture.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="courses")
public class Course {
    @Id
    @Column(name="id")
    private String courseId;

    @Column(name="courseName")
    private String courseName;

    @Column(name = "totalHours")
    private int totalHours;
}
