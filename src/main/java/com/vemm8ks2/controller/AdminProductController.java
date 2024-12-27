package com.vemm8ks2.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vemm8ks2.dto.request._ProductDTO;
import com.vemm8ks2.dto.response.GeneralResponse;
import com.vemm8ks2.model.Products;
import com.vemm8ks2.service.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin/product")
@RequiredArgsConstructor
public class AdminProductController {

  private final ProductService productService;

  @GetMapping
  public ResponseEntity<GeneralResponse<Page<Products>>> getAllProducts(
      @RequestParam(defaultValue = "0", name = "page") int page,
      @RequestParam(defaultValue = "10", name = "size") int size) {

    Page<Products> products = productService.getAllProducts(page, size);

    String msg = "page: " + page + " | size : " + size + " | 상품 데이터를 가져왔습니다.";
    GeneralResponse<Page<Products>> response = new GeneralResponse<Page<Products>>(msg, products);

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @PostMapping
  public Products createProduct(@RequestBody _ProductDTO productDTO) {
    return productService.createProduct(productDTO);
  }
}
