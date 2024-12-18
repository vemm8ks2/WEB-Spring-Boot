package com.vemm8ks2.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class _ProductOptionDTO {

  private int stock;
  private String size;
  private Long productId;

  public _ProductOptionDTO(int stock, String size) {
    this.stock = stock;
    this.size = size;
  }

}
