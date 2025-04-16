package com.maxdlr.graphql_test.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.maxdlr.graphql_test.entity.UserEntity;
import com.maxdlr.graphql_test.model.UserModel.UserInfo;
import com.maxdlr.graphql_test.model.UserModel.UserInput;
import com.maxdlr.graphql_test.repository.TeamRepository;

@Mapper(componentModel = "spring")
public abstract class UserMapper implements EntityMapper<UserInfo, UserInput, UserEntity> {
  @Autowired
  TeamRepository teamRepository;

  @Mapping(target = "team", expression = "java(this.teamRepository.findOneById((long) recordInput.getTeamId()))")
  public abstract UserEntity toEntityFromInput(UserInput recordInput);
}
