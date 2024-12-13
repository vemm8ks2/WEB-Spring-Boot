package com.vemm8ks2.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PaymentMethod {

  DIGITAL_WALLET("Digial wallet"), // 간편결제
  CREDIT_OR_DEBIT_CARD("Credit or debit card"), // 신용/체크카드 결제
  DEPOSIT_WITHOUT_PASSBOOK("Deposit without passbook"); // 무통장입금

  private final String value;

}
