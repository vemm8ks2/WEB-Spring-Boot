package com.vemm8ks2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Category {

  @Id
  private String id;

  @Column(nullable = false)
  private String name;

  private int level;

  @ManyToOne(fetch = FetchType.EAGER)
  @JsonIgnore
  private Category parentCategory;
}
