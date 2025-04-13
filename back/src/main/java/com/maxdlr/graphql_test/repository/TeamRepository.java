package com.maxdlr.graphql_test.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.maxdlr.graphql_test.entity.TeamEntity;
import com.maxdlr.graphql_test.model.TeamModel.*;

/**
 * TeamRepository
 */
public interface TeamRepository extends Repository<TeamEntity, Long> {

  List<Team> findAll();

  Team findOneById(long id);

  Team save(TeamInput team);

}
