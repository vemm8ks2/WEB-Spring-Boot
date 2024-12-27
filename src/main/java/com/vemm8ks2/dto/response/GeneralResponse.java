package com.vemm8ks2.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GeneralResponse<T> {

  private String message;
  private T data;

  public GeneralResponse(String message) {
    this.message = message;
    this.data = null;
  }

}
