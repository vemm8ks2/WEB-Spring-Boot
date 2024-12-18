package com.vemm8ks2.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vemm8ks2.model.Products;
import com.vemm8ks2.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin/product")
@RequiredArgsConstructor
public class AdminProductController {

  private final ProductRepository productRepository;

  @GetMapping
  public List<Products> getAllProducts() {
    return productRepository.findAll();
  }

  @PostMapping
  public Products createProduct(@RequestBody Products product) {
    return productRepository.save(product);
  }
}
