package com.vemm8ks2.service;

import java.util.List;
import org.springframework.data.domain.Page;
import com.vemm8ks2.dto.request._ProductDTO;
import com.vemm8ks2.model.Products;

public interface ProductService {

  public Products createProduct(_ProductDTO productDTO);

  public List<Products> getAllProducts();

  public Page<Products> getAllProducts(int page, int size);

  public Products getProductById(Long productId);

  public Page<Products> getProductsByCondition(Long categoryId, String keyword, Integer pageNumber,
      Integer pageSize);
}
