package com.vemm8ks2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

  @Min(value = 0)
  @Column(nullable = false)
  private double price;

  @Min(value = 0)
  @Column(nullable = false)
  private double totalPrice;

  @ManyToOne
  private Cart cart;
  
  @ManyToOne
  @JoinColumn(name = "product_id")
  private Products product;
}
