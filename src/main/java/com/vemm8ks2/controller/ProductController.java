package com.vemm8ks2.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vemm8ks2.model.Products;
import com.vemm8ks2.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/public/product")
@RequiredArgsConstructor
public class ProductController {

  private final ProductRepository productRepository;

  @GetMapping
  public ResponseEntity<List<Products>> getProducts() {
    List<Products> productList = productRepository.findAll();
    return ResponseEntity.ok(productList);
  }
}
