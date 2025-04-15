package com.maxdlr.graphql_test.repository;

import org.springframework.data.repository.Repository;

import com.maxdlr.graphql_test.entity.TeamEntity;

/**
 * TeamRepository
 */
public interface TeamRepository extends Repository<TeamEntity, Long>, CrudRepository<TeamEntity> {
}
