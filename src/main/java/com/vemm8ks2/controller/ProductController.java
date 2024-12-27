package com.vemm8ks2.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vemm8ks2.dto.response.GeneralResponse;
import com.vemm8ks2.model.Products;
import com.vemm8ks2.service.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/public/product")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping
  public ResponseEntity<GeneralResponse<Page<Products>>> getProducts(
      @RequestParam(required = false, name = "category_id") String categoryId,
      @RequestParam(required = false, name = "keyword") String keyword,
      @RequestParam(defaultValue = "0", name = "page") int page,
      @RequestParam(defaultValue = "10", name = "size") int size) {

    Page<Products> products =
        productService.getProductsByCondition(categoryId, keyword, page, size);

    String msg = "page: " + page + " | size : " + size + " | 상품 데이터를 가져왔습니다.";
    GeneralResponse<Page<Products>> response = new GeneralResponse<Page<Products>>(msg, products);

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
}
