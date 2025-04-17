package com.maxdlr.graphql_test.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.maxdlr.graphql_test.entity.TaskEntity;
import com.maxdlr.graphql_test.model.TaskModel.*;
import com.maxdlr.graphql_test.repository.TeamRepository;

@Mapper(componentModel = "spring")
public abstract class TaskMapper implements EntityMapper<TaskInfo, TaskInput, TaskEntity> {
  @Autowired
  TeamRepository teamRepository;

  @Mapping(target = "team", expression = "java(this.teamRepository.findOneById((long) taskInput.getTeamId()))")
  public abstract TaskEntity toEntityFromInput(TaskInput taskInput);

  @Mapping(target = "team", expression = "java(this.teamRepository.findOneById((long) taskInfo.getTeam().getId()))")
  public abstract TaskEntity toEntityFromInfo(TaskInfo taskInfo);
}
