package com.maxdlr.graphql_test.repository;

import java.util.List;

public interface CrudRepository<Entity> {
  Entity findOneById(long id);

  List<Entity> findAll();

  Entity save(Entity team);

}
