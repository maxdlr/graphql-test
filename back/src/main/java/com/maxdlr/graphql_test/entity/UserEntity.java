package com.maxdlr.graphql_test.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@EqualsAndHashCode
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserEntity {

  @GeneratedValue
  @Id
  private Long id;

  private String username;

  @ManyToOne
  private TeamEntity team;

  private List<String> taskTypes = new ArrayList<>();

  private Date createdAt;
}
