package com.vemm8ks2.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vemm8ks2.model.Products;
import com.vemm8ks2.service.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/public/product")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping
  public ResponseEntity<List<Products>> getProducts() {
    List<Products> productList = productService.getAllProducts();
    return ResponseEntity.ok(productList);
  }
}
