package com.maxdlr.graphql_test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maxdlr.graphql_test.entity.UserEntity;
import com.maxdlr.graphql_test.mapper.UserMapper;
import com.maxdlr.graphql_test.model.UserModel.UserInfo;
import com.maxdlr.graphql_test.model.UserModel.UserInput;
import com.maxdlr.graphql_test.repository.UserRepository;

@Service
public class UserService {

  private UserRepository userRepository;
  private UserMapper userMapper;

  public UserService(UserRepository userRepository, UserMapper userMapper) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
  }

  public UserEntity getEntity(Long id) {
    UserEntity fixtureUser = new UserEntity().setUsername("Maxdlr");
    this.userRepository.save(fixtureUser);
    return this.userRepository.findOnById((long) id);
  }

  public UserInfo getInfo(Long id) {
    return this.userMapper.toRecordInfo(this.getEntity(id));
  }

  public List<UserInfo> getAllInfo() {
    return this.userMapper.toRecordInfo(this.userRepository.findAll());
  }

  public UserEntity create(UserInput user) {
    UserEntity newUser = this.userMapper.toEntityFromInput(user);
    this.userRepository.save(newUser);
    return newUser;
  }
}
