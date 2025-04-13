package com.maxdlr.graphql_test.graphqlserver;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public record Team(
    Integer id,
    String name,
    String createdAt) {

  public static List<Team> teams = Arrays.asList(
      new Team(1, "First team", new Date().toString()),
      new Team(2, "Second team", new Date().toString()),
      new Team(3, "Second team", new Date().toString()));

  public static Team getById(Integer id) {
    return teams.stream().filter(team -> team.id().equals(id)).findFirst().orElse(null);
  }

}
