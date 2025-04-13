package com.maxdlr.graphql_test.model;

import static com.maxdlr.graphql_test.model.TeamModel.*;

public class UserModel {
  public static record User(
      Integer id,
      String username,
      Team team,
      String createdAt) {
  }

  public static record UserInput(
      String username,
      TeamInput team) {
  }
}
