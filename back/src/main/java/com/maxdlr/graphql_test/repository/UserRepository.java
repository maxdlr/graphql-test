package com.maxdlr.graphql_test.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.maxdlr.graphql_test.entity.UserEntity;
import static com.maxdlr.graphql_test.model.UserModel.*;

public interface UserRepository extends Repository<UserEntity, Long> {

  UserEntity findOnById(long id);

  List<UserEntity> findAll();

  UserEntity save(UserInput user);
}
