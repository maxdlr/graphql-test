package com.maxdlr.graphql_test.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.maxdlr.graphql_test.graphqlserver.User;

@Controller
public class UserController {
  @QueryMapping
  public User userById(@Argument Integer id) {
    return User.userById(id);
  }

  @QueryMapping
  public List<User> users() {
    return User.users();
  }
}
