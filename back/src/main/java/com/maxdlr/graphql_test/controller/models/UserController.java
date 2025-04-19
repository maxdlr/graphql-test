package com.maxdlr.graphql_test.controller.models;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.maxdlr.graphql_test.model.UserModel.UserInfo;
import com.maxdlr.graphql_test.model.UserModel.UserInput;
import com.maxdlr.graphql_test.service.models.UserService;

@Controller
public class UserController {
  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @QueryMapping
  public UserInfo GetUser(@Argument Integer id) {
    return this.userService.getInfo(Long.valueOf(id));
  }

  @QueryMapping
  public List<UserInfo> GetAllUsers() {
    return this.userService.getAllInfo();
  }

  @MutationMapping()
  public UserInfo CreateUser(
      @Argument UserInput user) {
    return this.userService.create(user);
  }

  @MutationMapping()
  public UserInfo UpdateUser(
      @Argument UserInput user) throws Exception {
    return this.userService.update(user);
  }

  @MutationMapping
  public UserInfo AddTaskTypeToUser(
      @Argument Integer id,
      @Argument String type) throws Exception {
    return this.userService.addTaskType((long) id, type);
  }

  @MutationMapping
  public UserInfo RemoveTaskTypeToUser(
      @Argument Integer id,
      @Argument String type) throws Exception {
    return this.userService.removeTaskType((long) id, type);
  }
}
