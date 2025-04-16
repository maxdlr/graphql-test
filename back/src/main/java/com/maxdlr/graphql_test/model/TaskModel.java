package com.maxdlr.graphql_test.model;

import java.util.Date;

import com.maxdlr.graphql_test.model.TeamModel.TeamInfo;

public class TaskModel {
  public record TaskInfo(
      Integer id,
      String title,
      String description,
      TeamInfo team,
      String type,
      Date createdAt) {
    public Integer getId() {
      return id;
    }
  }

  public record TaskInput(
      String title,
      String description,
      Integer teamId,
      String type) {
    public Integer getTeamId() {
      return teamId;
    }
  }
}
