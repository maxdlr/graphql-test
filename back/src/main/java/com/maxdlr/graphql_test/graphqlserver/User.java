package com.maxdlr.graphql_test.graphqlserver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public record User(
    Integer id,
    String username,
    Team team,
    String createdAt) {

  public static List<User> users() {
    List<User> users = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
      User user = new User(i, "user - " + i, Team.teamById(1), new Date().toString());
      users.add(user);
    }
    return users;
  }

  public static User userById(Integer id) {
    return users().stream().filter(user -> user.id().equals(id)).findFirst().orElse(null);
  }
}
