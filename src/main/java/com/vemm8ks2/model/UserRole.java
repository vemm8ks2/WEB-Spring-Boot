package com.vemm8ks2.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserRole {

  ADMIN("ROLE_ADMIN"), USER("ROLE_USER");

  private final String value;
}
