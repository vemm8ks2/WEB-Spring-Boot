package com.vemm8ks2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CartItems {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Min(value = 0)
  @Column(nullable = false)
  private int quantity;

  @Column(nullable = false)
  private String size;

  @ManyToOne
  @JsonIgnore
  private Cart cart;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "product_id")
  private Products product;
}
