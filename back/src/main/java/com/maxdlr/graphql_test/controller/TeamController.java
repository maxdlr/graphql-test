package com.maxdlr.graphql_test.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.maxdlr.graphql_test.graphqlserver.Team;

@Controller
public class TeamController {
  @QueryMapping
  public Team teamById(@Argument Integer id) {
    return Team.getById(id);
  }

  @QueryMapping
  public List<Team> teams(@Argument Integer id) {
    return Team.teams;
  }
}
