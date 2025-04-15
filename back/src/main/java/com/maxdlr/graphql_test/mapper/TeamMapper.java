package com.maxdlr.graphql_test.mapper;

import org.mapstruct.Mapper;

import com.maxdlr.graphql_test.entity.TeamEntity;
import com.maxdlr.graphql_test.model.TeamModel.TeamInfo;
import com.maxdlr.graphql_test.model.TeamModel.TeamInput;

@Mapper(componentModel = "spring")
public interface TeamMapper extends EntityMapper<TeamInfo, TeamInput, TeamEntity> {
}
