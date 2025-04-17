package com.maxdlr.graphql_test.service;

/**
 * CrudServiceInterface
 */
public interface CrudServiceInterface<Info, Input> {
  public Info update(Input input);
}
