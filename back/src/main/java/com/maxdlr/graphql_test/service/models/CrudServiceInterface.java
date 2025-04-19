package com.maxdlr.graphql_test.service.models;

/**
 * CrudServiceInterface
 */
public interface CrudServiceInterface<Info, Input> {
  public Info update(Input input) throws Exception;
}
