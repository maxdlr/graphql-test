package com.maxdlr.graphql_test.service.models;

import org.springframework.stereotype.Service;

import com.maxdlr.graphql_test.entity.TeamEntity;
import com.maxdlr.graphql_test.mapper.TeamMapper;
import com.maxdlr.graphql_test.model.TeamModel.TeamInfo;
import com.maxdlr.graphql_test.model.TeamModel.TeamInput;
import com.maxdlr.graphql_test.repository.TeamRepository;

@Service
public class TeamService extends CrudService<TeamRepository, TeamMapper, TeamEntity, TeamInfo, TeamInput>
    implements CrudServiceInterface<TeamInfo, TeamInput> {
  public TeamService(final TeamRepository repository, final TeamMapper mapper) {
    super(repository, mapper);
  }

  public TeamInfo update(final TeamInput input) {
    final TeamEntity entity = this.repository.findOneById(input.getId());
    if (entity == null) {
      return null;
    }

    if (input.getName() == null) {
      return this.mapper.toRecordInfo(entity);

    }

    entity.setName(input.getName());
    final TeamEntity savedEntity = this.repository.save(entity);

    return this.mapper.toRecordInfo(savedEntity);
  }
}
