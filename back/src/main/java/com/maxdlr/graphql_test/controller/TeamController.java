package com.maxdlr.graphql_test.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.maxdlr.graphql_test.entity.TeamEntity;
import com.maxdlr.graphql_test.repository.TeamRepository;

import static com.maxdlr.graphql_test.model.TeamModel.*;

@Controller
public class TeamController {
  private TeamRepository teamRepository;

  public TeamController(TeamRepository teamRepository) {
    this.teamRepository = teamRepository;
  }

  @QueryMapping
  public TeamEntity GetTeam(@Argument Integer id) {
    return this.teamRepository.findOneById((long) id);
  }

  @QueryMapping
  public List<TeamEntity> GetAllTeams() {
    return this.teamRepository.findAll();
  }

  @MutationMapping
  public TeamEntity CreateTeam(@Argument TeamInput team) {
    return this.teamRepository.save(team);
  }
}
