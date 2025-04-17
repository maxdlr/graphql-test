package com.maxdlr.graphql_test.service;

import org.springframework.stereotype.Service;

import com.maxdlr.graphql_test.entity.TaskEntity;
import com.maxdlr.graphql_test.mapper.TaskMapper;
import com.maxdlr.graphql_test.model.TaskModel.TaskInfo;
import com.maxdlr.graphql_test.model.TaskModel.TaskInput;
import com.maxdlr.graphql_test.repository.TaskRepository;

@Service
public class TaskService extends CrudService<TaskRepository, TaskMapper, TaskEntity, TaskInfo, TaskInput> {
  public TaskService(TaskRepository repository, TaskMapper mapper) {
    super(repository, mapper);
  }
}
