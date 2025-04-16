package com.maxdlr.graphql_test.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.maxdlr.graphql_test.model.TaskModel.TaskInfo;
import com.maxdlr.graphql_test.model.TaskModel.TaskInput;
import com.maxdlr.graphql_test.service.TaskService;

@Controller
public class TaskController {
  private TaskService userService;

  public TaskController(TaskService userService) {
    this.userService = userService;
  }

  @QueryMapping
  public TaskInfo GetTask(@Argument Integer id) {
    return this.userService.getInfo(Long.valueOf(id));
  }

  @QueryMapping
  public List<TaskInfo> GetAllTasks() {
    return this.userService.getAllInfo();
  }

  @MutationMapping()
  public TaskInfo CreateTask(
      @Argument TaskInput user) {
    return this.userService.create(user);
  }
}
