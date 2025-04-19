package com.maxdlr.graphql_test.repository;

import org.springframework.data.repository.Repository;

import com.maxdlr.graphql_test.entity.TaskEntity;

/**
 * TaskRepository
 */
public interface TaskRepository extends Repository<TaskEntity, Long>, CrudRepository<TaskEntity> {
}
