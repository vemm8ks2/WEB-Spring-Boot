package com.vemm8ks2.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserGender {

  MALE("Male"), FEMALE("Female"), OTHER("Other");

  private final String value;
}
