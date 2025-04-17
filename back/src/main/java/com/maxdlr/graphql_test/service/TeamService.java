package com.maxdlr.graphql_test.service;

import org.springframework.stereotype.Service;

import com.maxdlr.graphql_test.entity.TeamEntity;
import com.maxdlr.graphql_test.mapper.TeamMapper;
import com.maxdlr.graphql_test.model.TeamModel.TeamInfo;
import com.maxdlr.graphql_test.model.TeamModel.TeamInput;
import com.maxdlr.graphql_test.repository.TeamRepository;

@Service
public class TeamService extends CrudService<TeamRepository, TeamMapper, TeamEntity, TeamInfo, TeamInput> {
  public TeamService(TeamRepository repository, TeamMapper mapper) {
    super(repository, mapper);
  }
}
