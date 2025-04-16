package com.maxdlr.graphql_test.service;

import org.springframework.stereotype.Service;

import com.maxdlr.graphql_test.entity.TaskEntity;
import com.maxdlr.graphql_test.mapper.EntityMapper;
import com.maxdlr.graphql_test.model.TaskModel.TaskInfo;
import com.maxdlr.graphql_test.model.TaskModel.TaskInput;
import com.maxdlr.graphql_test.repository.TaskRepository;

@Service
public class TaskService extends CrudService<TaskRepository, TaskEntity, TaskInfo, TaskInput> {
  public TaskService(TaskRepository Repository, EntityMapper<TaskInfo, TaskInput, TaskEntity> Mapper) {
    super(Repository, Mapper);
  }
}
