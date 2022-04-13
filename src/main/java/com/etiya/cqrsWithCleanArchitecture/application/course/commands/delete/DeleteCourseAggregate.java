package com.etiya.cqrsWithCleanArchitecture.application.course.commands.delete;

import com.etiya.cqrsWithCleanArchitecture.application.course.commands.create.CourseCreatedEvent;
import com.etiya.cqrsWithCleanArchitecture.application.course.commands.create.CreateCourseCommand;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class DeleteCourseAggregate {
    @AggregateIdentifier
    private String courseId;

    @CommandHandler
    public DeleteCourseAggregate(DeleteCourseCommand command){
        CourseDeletedEvent courseDeletedEvent= new CourseDeletedEvent();
        BeanUtils.copyProperties(command,courseDeletedEvent);
        AggregateLifecycle.apply(courseDeletedEvent);

    }

    @EventSourcingHandler //Silmelisin!!!
    public void on (CourseDeletedEvent courseDeletedEvent){
        this.courseId=courseDeletedEvent.getCourseId();
    }
}
