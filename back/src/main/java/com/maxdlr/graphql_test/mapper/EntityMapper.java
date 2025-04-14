package com.maxdlr.graphql_test.mapper;

import java.util.List;

public interface EntityMapper<RecordInfo, RecordInput, Entity> {
  Entity toEntityFromInfo(RecordInfo recordInfo);

  RecordInfo toRecordInfo(Entity entity);

  Entity toEntityFromInput(RecordInput recordInput);

  List<Entity> toEntityFromInfo(List<RecordInfo> recordInfo);

  List<RecordInfo> toRecordInfo(List<Entity> entity);

  List<Entity> toEntityFromInput(List<RecordInput> recordInput);
}
