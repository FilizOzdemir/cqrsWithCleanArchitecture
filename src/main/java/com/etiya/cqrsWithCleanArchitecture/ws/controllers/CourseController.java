package com.etiya.cqrsWithCleanArchitecture.ws.controllers;

import com.etiya.cqrsWithCleanArchitecture.application.accountTypes.commands.create.CreateAccountTypeCommand;
import com.etiya.cqrsWithCleanArchitecture.application.course.commands.create.CreateCourseCommand;
import com.etiya.cqrsWithCleanArchitecture.application.course.commands.delete.DeleteCourseCommand;
import com.etiya.cqrsWithCleanArchitecture.application.course.commands.update.UpdateCourseCommand;
import com.etiya.cqrsWithCleanArchitecture.ws.models.CreateAccountTypeModel;
import com.etiya.cqrsWithCleanArchitecture.ws.models.CreateCourseModel;
import com.etiya.cqrsWithCleanArchitecture.ws.models.DeleteCourseModel;
import com.etiya.cqrsWithCleanArchitecture.ws.models.UpdateCourseModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private CommandGateway commandGateway;

    public CourseController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }
    @PostMapping("add")
    public void add(@RequestBody CreateCourseModel createCourseModel) {

        CreateCourseCommand command=CreateCourseCommand.builder()
                .courseName(createCourseModel.getCourseName())
                .totalHours(createCourseModel.getTotalHours())
                .build();
        command.setCourseId(UUID.randomUUID().toString());
        this.commandGateway.sendAndWait(command);
    }
    @DeleteMapping("delete")
    public void delete(@RequestBody DeleteCourseModel deleteCourseModel) {

        DeleteCourseCommand command =DeleteCourseCommand.builder()
                .courseId(deleteCourseModel.getCourseId())
                .build();

        command.setCourseId(UUID.randomUUID().toString());
        this.commandGateway.sendAndWait(command);
    }

    @GetMapping("update")
    public void update(@RequestBody UpdateCourseModel updateCourseModel) {

        UpdateCourseCommand command =UpdateCourseCommand.builder()
                .courseId(updateCourseModel.getCourseId())
                .courseName(updateCourseModel.getCourseName())
                .totalHours(updateCourseModel.getTotalHours())
                .build();

        command.setCourseId(UUID.randomUUID().toString());

        this.commandGateway.sendAndWait(command);
    }
}
