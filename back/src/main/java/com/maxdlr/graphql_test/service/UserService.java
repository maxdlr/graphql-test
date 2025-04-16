package com.maxdlr.graphql_test.service;

import org.springframework.stereotype.Service;

import com.maxdlr.graphql_test.entity.UserEntity;
import com.maxdlr.graphql_test.mapper.EntityMapper;
import com.maxdlr.graphql_test.model.UserModel.UserInfo;
import com.maxdlr.graphql_test.model.UserModel.UserInput;
import com.maxdlr.graphql_test.repository.UserRepository;

@Service
public class UserService extends CrudService<UserRepository, UserEntity, UserInfo, UserInput> {
  public UserService(UserRepository Repository, EntityMapper<UserInfo, UserInput, UserEntity> Mapper) {
    super(Repository, Mapper);
  }
}
