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

    public TeamInfo getTeam() {
      return team;
    }
  }

  public record TaskInput(
      Integer id,
      String title,
      String description,
      Integer teamId,
      String type) {
    public Integer getId() {
      return id;
    }

    public String getTitle() {
      return title;
    }

    public String getDescription() {
      return description;
    }

    public Integer getTeamId() {
      return teamId;
    }

    public String getType() {
      return type;
    }
  }
}
