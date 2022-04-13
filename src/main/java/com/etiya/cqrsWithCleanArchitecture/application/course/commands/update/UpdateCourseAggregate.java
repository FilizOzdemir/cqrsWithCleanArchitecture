package com.etiya.cqrsWithCleanArchitecture.application.course.commands.update;

import com.etiya.cqrsWithCleanArchitecture.application.course.commands.create.CourseCreatedEvent;
import com.etiya.cqrsWithCleanArchitecture.application.course.commands.create.CreateCourseCommand;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class UpdateCourseAggregate {
    @AggregateIdentifier
    private String  courseId;
    private String courseName;
    private int totalHours;

    @CommandHandler
    public UpdateCourseAggregate(UpdateCourseCommand command){
        CourseUpdatedEvent courseUpdatedEvent=new CourseUpdatedEvent();
        BeanUtils.copyProperties(command,courseUpdatedEvent);
        AggregateLifecycle.apply(courseUpdatedEvent);
    }

    @EventSourcingHandler
    public void on (CourseUpdatedEvent courseUpdatedEvent){
        this.courseId=courseUpdatedEvent.getCourseId();
        this.courseName=courseUpdatedEvent.getCourseName();
        this.totalHours=courseUpdatedEvent.getTotalHours();
    }
}
