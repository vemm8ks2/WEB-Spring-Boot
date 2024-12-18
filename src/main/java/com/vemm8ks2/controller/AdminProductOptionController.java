package com.vemm8ks2.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vemm8ks2.dto.request._ProductOptionDTO;
import com.vemm8ks2.model.ProductOptions;
import com.vemm8ks2.service.ProductOptionService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin/product-option")
@RequiredArgsConstructor
public class AdminProductOptionController {

  private final ProductOptionService productOptionService;

  @PostMapping
  public ProductOptions createProductOption(@RequestBody _ProductOptionDTO productOptionDTO) {
    return productOptionService.createProductOption(productOptionDTO);
  }
}
