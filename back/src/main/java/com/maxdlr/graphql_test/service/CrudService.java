package com.maxdlr.graphql_test.service;

import java.util.List;

import com.maxdlr.graphql_test.mapper.EntityMapper;
import com.maxdlr.graphql_test.repository.CrudRepository;

/**
 * CrudService
 */
public class CrudService<EntityRepository extends CrudRepository<Entity>, Entity, Info, Input> {
  private final EntityRepository EntityRepository;
  private final EntityMapper<Info, Input, Entity> Mapper;

  public CrudService(final EntityRepository EntityRepository, final EntityMapper<Info, Input, Entity> Mapper) {
    this.EntityRepository = EntityRepository;
    this.Mapper = Mapper;
  }

  public Entity getEntity(final Long id) {
    return this.EntityRepository.findOneById((long) id);
  }

  public Info getInfo(final Long id) {
    return this.Mapper.toRecordInfo(this.getEntity(id));
  }

  public List<Info> getAllInfo() {
    return this.Mapper.toRecordInfo(this.EntityRepository.findAll());
  }

  public Info create(final Input input) {
    final Entity newEntity = this.Mapper.toEntityFromInput(input);
    this.EntityRepository.save(newEntity);
    return this.Mapper.toRecordInfo(newEntity);
  }
}
