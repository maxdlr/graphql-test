package com.maxdlr.graphql_test.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TeamEntity {

  @GeneratedValue
  @Id
  private Long id;

  private String name;

  private Date createdAt;
}
