package com.maxdlr.graphql_test.model;

public class TeamModel {

  public static record TeamInfo(
      Integer id,
      String name,
      String createdAt) {
  }

  public static record TeamInput(
      String name) {
  }
}
