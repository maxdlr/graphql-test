package com.maxdlr.graphql_test.entity;

import java.util.Date;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

  @Generated(value = { "id" })
  @Id
  private Long id;

  private String username;

  @ManyToOne
  private TeamEntity team;

  private Date createdAt;
}
