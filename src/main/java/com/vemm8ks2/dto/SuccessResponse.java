package com.vemm8ks2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SuccessResponse<T> {

  private String message;
  private T data;

  public SuccessResponse(String message) {
    this.message = message;
    this.data = null;
  }

}
