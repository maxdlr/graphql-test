package com.maxdlr.graphql_test.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import static com.maxdlr.graphql_test.model.UserModel.*;
import static com.maxdlr.graphql_test.model.TeamModel.*;
import com.maxdlr.graphql_test.repository.UserRepository;
import com.maxdlr.graphql_test.entity.UserEntity;

@Controller
public class UserController {
  private UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @QueryMapping
  public UserEntity GetUser(@Argument Integer id) {

    this.userRepository.save(new UserInput("Maxime", new TeamInput("my team")));

    return this.userRepository.findOnById((long) id);
  }

  @QueryMapping
  public List<UserEntity> GetAllUsers() {
    return this.userRepository.findAll();
  }

  @MutationMapping()
  public UserEntity CreateUser(
      @Argument UserInput user) {
    return this.userRepository.save(user);
  }
}
