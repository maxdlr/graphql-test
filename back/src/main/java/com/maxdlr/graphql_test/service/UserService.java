package com.maxdlr.graphql_test.service;

import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.maxdlr.graphql_test.entity.TeamEntity;
import com.maxdlr.graphql_test.entity.UserEntity;
import com.maxdlr.graphql_test.mapper.UserMapper;
import com.maxdlr.graphql_test.model.UserModel.UserInfo;
import com.maxdlr.graphql_test.model.UserModel.UserInput;
import com.maxdlr.graphql_test.repository.UserRepository;

@Service
public class UserService extends CrudService<UserRepository, UserMapper, UserEntity, UserInfo, UserInput>
    implements CrudServiceInterface<UserInfo, UserInput> {

  private final TeamService teamService;

  public UserService(final UserRepository repository, final UserMapper mapper, final TeamService teamService) {
    super(repository, mapper);
    this.teamService = teamService;
  }

  public UserInfo update(final UserInput input) throws Exception {

    if (input.getId() == null) {
      throw new Exception("The input doesn't have an id");
    }

    final UserEntity user = this.repository.findOneById(input.getId());

    if (user == null) {
      throw new Exception("The requested user is not found");
    }

    if (input.getUsername() != null) {
      user.setUsername(input.getUsername());
    }

    if (!input.getTaskTypes().isEmpty()) {
      user.setTaskTypes(input.getTaskTypes());
    }

    if (input.getTeamId() != null) {
      final TeamEntity team = this.teamService.getEntity((long) input.getTeamId());
      if (team == null) {
        throw new Exception("The input's team is not found");
      }
      user.setTeam(team);
    }

    final UserEntity savedUser = this.repository.save(user);

    return this.mapper.toRecordInfo(user);
  }

  public UserInfo addTaskType(long id, String type) throws Exception {
    UserEntity user = this.repository.findOneById(id);

    if (user == null) {
      throw new Exception("Cannot find user");
    }

    List<String> types = user.getTaskTypes();
    types.add(type);

    user.setTaskTypes(types);

    final UserEntity savedUser = this.repository.save(user);

    return this.mapper.toRecordInfo(user);
  }

  public UserInfo removeTaskType(long id, String type) throws Exception {
    UserEntity user = this.repository.findOneById(id);

    if (user == null) {
      throw new Exception("Cannot find user");
    }

    List<String> types = user.getTaskTypes();

    types.removeIf(listType -> listType == type);

    user.setTaskTypes(types);

    final UserEntity savedUser = this.repository.save(user);

    return this.mapper.toRecordInfo(user);
  }
}
