package com.maxdlr.graphql_test.graphqlserver;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public record User(
    Integer id,
    String username,
    Team team,
    String createdAt) {

  private static List<User> users = Arrays.asList(
      new User(1, "maxdlr", Team.getById(1), new Date().toString()),
      new User(2, "polygone", Team.getById(2), new Date().toString()));

  public static User getById(Integer id) {
    return users.stream().filter(user -> user.id().equals(id)).findFirst().orElse(null);
  }
}
