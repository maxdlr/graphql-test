package com.maxdlr.graphql_test.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.maxdlr.graphql_test.entity.UserEntity;
import com.maxdlr.graphql_test.mapper.UserMapper;
import com.maxdlr.graphql_test.model.UserModel.UserInfo;
import com.maxdlr.graphql_test.model.UserModel.UserInput;
import com.maxdlr.graphql_test.repository.UserRepository;
import com.maxdlr.graphql_test.service.UserService;

@Controller
public class UserController {
  private UserRepository userRepository;
  private UserMapper userMapper;
  private UserService userService;

  public UserController(UserRepository userRepository, UserMapper userMapper, UserService userService) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
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
  public UserEntity CreateUser(
      @Argument UserInput user) {
    return this.userService.create(user);
  }
}
