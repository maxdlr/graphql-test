package com.maxdlr.graphql_test.controller.models;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.maxdlr.graphql_test.model.TeamModel.TeamInfo;
import com.maxdlr.graphql_test.model.TeamModel.TeamInput;
import com.maxdlr.graphql_test.service.models.TeamService;

@Controller
public class TeamController {
  private TeamService teamService;

  public TeamController(TeamService teamService) {
    this.teamService = teamService;
  }

  @QueryMapping
  public TeamInfo GetTeam(@Argument Integer id) {
    return this.teamService.getInfo((long) id);
  }

  @QueryMapping
  public List<TeamInfo> GetAllTeams() {
    return this.teamService.getAllInfo();
  }

  @MutationMapping
  public TeamInfo CreateTeam(@Argument TeamInput team) {
    return this.teamService.create(team);
  }

  @MutationMapping
  public TeamInfo UpdateTeam(@Argument TeamInput team) {
    return this.teamService.update(team);
  }
}
