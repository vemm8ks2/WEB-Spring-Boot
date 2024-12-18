package com.vemm8ks2.dto.request;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class _BetweenDateDTO {

  private LocalDateTime startDate;
  private LocalDateTime endDate;
}
