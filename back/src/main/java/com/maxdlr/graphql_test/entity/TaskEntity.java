package com.maxdlr.graphql_test.entity;

import java.util.Date;

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
public class TaskEntity {

  @GeneratedValue
  @Id
  private Long id;

  private String title;

  private String description;

  @ManyToOne
  private TeamEntity team;

  private String type;

  private Date createdAt;

}
