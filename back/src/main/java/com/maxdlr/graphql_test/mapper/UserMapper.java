package com.maxdlr.graphql_test.mapper;

import com.maxdlr.graphql_test.entity.UserEntity;
import static com.maxdlr.graphql_test.model.UserModel.*;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserInfo, UserInput, UserEntity> {
}
