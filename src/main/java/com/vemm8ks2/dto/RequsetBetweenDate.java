package com.vemm8ks2.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequsetBetweenDate {

  private LocalDateTime startDate;
  private LocalDateTime endDate;
}
