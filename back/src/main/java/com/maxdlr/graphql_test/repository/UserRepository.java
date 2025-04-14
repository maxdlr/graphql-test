package com.maxdlr.graphql_test.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.maxdlr.graphql_test.entity.UserEntity;

public interface UserRepository extends Repository<UserEntity, Long> {

  UserEntity findOnById(long id);

  List<UserEntity> findAll();

  UserEntity save(UserEntity user);
}
