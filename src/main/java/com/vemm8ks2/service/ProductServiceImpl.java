package com.vemm8ks2.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.vemm8ks2.exception.NotFoundException;
import com.vemm8ks2.model.Products;
import com.vemm8ks2.repository.ProductRepository;
import com.vemm8ks2.repository.ProductSpec;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  @Override
  public Products createProduct(Products product) {
    return productRepository.save(product);
  }

  @Override
  public Products getProductById(Long productId) {
    return productRepository.findById(productId)
        .orElseThrow(() -> new NotFoundException("상품이 존재하지 않습니다."));
  }

  @Override
  public Page<Products> getProductsByCondition(Long categoryId, String keyword, Integer pageNumber,
      Integer pageSize) {

    Specification<Products> spec = Specification.where(null);

    if (categoryId != null) {
      spec = spec.and(ProductSpec.hasCategory(categoryId));
    }

    if (keyword != null) {
      spec = spec.and(ProductSpec.hasTitle(keyword));
    }

    Pageable pageable = PageRequest.of(pageNumber, pageSize);

    return productRepository.findAll(spec, pageable);
  }

}
