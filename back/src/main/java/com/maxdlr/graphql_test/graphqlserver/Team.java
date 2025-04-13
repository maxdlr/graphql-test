package com.maxdlr.graphql_test.graphqlserver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public record Team(
    Integer id,
    String name,
    String createdAt) {

  public static List<Team> teams() {
    List<Team> teams = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
      Team team = new Team(i, "teamname - " + i, new Date().toString());
      teams.add(team);
    }
    return teams;
  }

  public static Team teamById(Integer id) {
    return teams().stream().filter(team -> team.id().equals(id)).findFirst().orElse(null);
  }

}
