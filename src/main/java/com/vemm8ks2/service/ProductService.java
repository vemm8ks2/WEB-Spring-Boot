package com.vemm8ks2.service;

import org.springframework.data.domain.Page;
import com.vemm8ks2.model.Products;

public interface ProductService {

  public Products createProduct(Products product);

  public Products getProductById(Long productId);

  public Page<Products> getProductsByCondition(String category, String keyword, Integer pageNumber,
      Integer pageSize);
}
