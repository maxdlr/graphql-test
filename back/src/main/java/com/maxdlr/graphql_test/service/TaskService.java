package com.maxdlr.graphql_test.service;

import org.springframework.stereotype.Service;

import com.maxdlr.graphql_test.entity.TaskEntity;
import com.maxdlr.graphql_test.mapper.TaskMapper;
import com.maxdlr.graphql_test.model.TaskModel.TaskInfo;
import com.maxdlr.graphql_test.model.TaskModel.TaskInput;
import com.maxdlr.graphql_test.repository.TaskRepository;
import com.maxdlr.graphql_test.repository.TeamRepository;

@Service
public class TaskService extends CrudService<TaskRepository, TaskMapper, TaskEntity, TaskInfo, TaskInput>
    implements CrudServiceInterface<TaskInfo, TaskInput> {
  private TeamRepository teamRepository;

  public TaskService(TaskRepository repository, TaskMapper mapper, TeamRepository teamRepository) {
    super(repository, mapper);
    this.teamRepository = teamRepository;
  }

  public TaskInfo update(TaskInput input) throws Exception {
    TaskEntity task = this.repository.findOneById(input.getId());

    if (task == null) {
      throw new Exception("Cannot find task");
    }

    if (input.getTitle() != null) {
      task.setTitle(input.getTitle());
    }
    if (input.getDescription() != null) {
      task.setDescription(input.getDescription());
    }
    if (input.getTeamId() != null) {
      task.setTeam(this.teamRepository.findOneById(input.getTeamId()));
    }

    if (input.getType() != null) {
      task.setType(input.getType());
    }

    this.repository.save(task);

    return this.mapper.toRecordInfo(task);
  }
}
