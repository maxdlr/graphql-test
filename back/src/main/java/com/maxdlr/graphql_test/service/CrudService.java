package com.maxdlr.graphql_test.service;

import java.util.List;

import com.maxdlr.graphql_test.mapper.EntityMapper;
import com.maxdlr.graphql_test.repository.CrudRepository;

public class CrudService<Repository extends CrudRepository<Entity>, Mapper extends EntityMapper<Info, Input, Entity>, Entity, Info, Input> {
  protected final Repository repository;
  protected Mapper mapper;

  public CrudService(final Repository repository, final Mapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  public Entity getEntity(final Long id) {
    return this.repository.findOneById((long) id);
  }

  public Info getInfo(final Long id) {
    return this.mapper.toRecordInfo(this.getEntity(id));
  }

  public List<Info> getAllInfo() {
    return this.mapper.toRecordInfo(this.repository.findAll());
  }

  public Info create(final Input input) {
    final Entity newEntity = this.mapper.toEntityFromInput(input);
    this.repository.save(newEntity);
    return this.mapper.toRecordInfo(newEntity);
  }
}
