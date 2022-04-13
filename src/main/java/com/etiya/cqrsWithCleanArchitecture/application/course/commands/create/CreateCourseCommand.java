package com.etiya.cqrsWithCleanArchitecture.application.course.commands.create;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CreateCourseCommand {
    @TargetAggregateIdentifier
    private String courseId;
    private String courseName;
    private int totalHours;

}
