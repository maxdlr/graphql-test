package com.maxdlr.graphql_test.model;

import java.util.List;

import com.maxdlr.graphql_test.model.TeamModel.TeamInfo;

public class UserModel {
  public static record UserInfo(
      Integer id,
      String username,
      TeamInfo team,
      List<String> taskTypes,
      String createdAt) {
    public TeamInfo getTeam() {
      return team;
    }

    public Integer getId() {
      return id;
    }
  }

  public static record UserInput(
      String username,
      List<String> taskTypes,
      Integer teamId) {

    public Integer getTeamId() {
      return teamId;
    }
  }
}
