package com.vemm8ks2.service;

import java.util.Optional;
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

    Products _product = new Products();

    _product.setTitle(product.getTitle());
    _product.setImageUrl(product.getImageUrl());
    _product.setPrice(product.getPrice());
    _product.setCategory(product.getCategory());
    _product.setProductOptions(product.getProductOptions());

    return _product;
  }

  @Override
  public Products getProductById(Long productId) {

    Optional<Products> optional = productRepository.findById(productId);

    if (optional.isEmpty()) {
      throw new NotFoundException("상품이 존재하지 않습니다.");
    }

    return optional.get();
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
