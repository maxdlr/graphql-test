package com.maxdlr.graphql_test.model;

import static com.maxdlr.graphql_test.model.TeamModel.*;

public class UserModel {
  public static record UserInfo(
      Integer id,
      String username,
      TeamInfo team,
      String createdAt) {
  }

  public static record UserInput(
      String username,
      Integer teamId) {

    public Integer getTeamId() {
      return teamId;
    }
  }
}
