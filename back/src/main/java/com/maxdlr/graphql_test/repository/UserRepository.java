package com.maxdlr.graphql_test.repository;

import org.springframework.data.repository.Repository;

import com.maxdlr.graphql_test.entity.UserEntity;

public interface UserRepository extends Repository<UserEntity, Long>, CrudRepository<UserEntity> {
}
