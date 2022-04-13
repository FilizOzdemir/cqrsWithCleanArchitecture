package com.etiya.cqrsWithCleanArchitecture.application.course.commands.update;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class UpdateCourseCommand {

    @TargetAggregateIdentifier
    private String  courseId;
    private String courseName;
    private int totalHours;
}
