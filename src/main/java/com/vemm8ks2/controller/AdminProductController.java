package com.vemm8ks2.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vemm8ks2.dto.request._ProductDTO;
import com.vemm8ks2.model.Products;
import com.vemm8ks2.service.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin/product")
@RequiredArgsConstructor
public class AdminProductController {

  private final ProductService productService;

  @GetMapping
  public List<Products> getAllProducts() {
    return productService.getAllProducts();
  }

  @PostMapping
  public Products createProduct(@RequestBody _ProductDTO productDTO) {
    return productService.createProduct(productDTO);
  }
}
