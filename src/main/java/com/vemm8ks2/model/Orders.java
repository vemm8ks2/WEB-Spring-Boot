package com.vemm8ks2.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Orders {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String shippingAddress;

  private String receiverName;
  private String receiverPhone;

  @Column(nullable = false)
  private LocalDateTime deliveredAt;

  @Column(nullable = false)
  private double totalPrice;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private PaymentMethod paymentMethod;

  @ManyToOne
  private Users user;

  @OneToMany(mappedBy = "order")
  private List<OrderItems> orderItems = new ArrayList<>();

  public Orders() {
    this.deliveredAt = LocalDateTime.now();
  }
}
