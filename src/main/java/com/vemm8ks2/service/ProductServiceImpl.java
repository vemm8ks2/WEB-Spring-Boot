package com.vemm8ks2.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.vemm8ks2.dto.request._ProductDTO;
import com.vemm8ks2.dto.request._ProductOptionDTO;
import com.vemm8ks2.exception.NotFoundException;
import com.vemm8ks2.model.Category;
import com.vemm8ks2.model.ProductOptions;
import com.vemm8ks2.model.Products;
import com.vemm8ks2.repository.ProductRepository;
import com.vemm8ks2.repository.ProductSpec;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;
  private final ProductOptionService productOptionService;
  private final CategoryService categoryService;

  @Override
  @Transactional
  public Products createProduct(_ProductDTO productDTO) {

    Category category = categoryService.getCategoryById(productDTO.getCategoryId());

    Products product = new Products();

    product.setTitle(productDTO.getTitle());
    product.setPrice(productDTO.getPrice());
    product.setImageUrl(productDTO.getImageUrl());
    product.setCategory(category);

    product = productRepository.save(product);

    for (_ProductOptionDTO option : productDTO.getProductOptions()) {
      ProductOptions _productOption = new ProductOptions();

      _productOption.setSize(option.getSize());
      _productOption.setStock(option.getStock());
      _productOption.setProduct(product);

      productOptionService.createProductOption(_productOption);
    }

    return product;
  }

  @Override
  public List<Products> getAllProducts() {
    return productRepository.findAll();
  }

  @Override
  public Page<Products> getAllProducts(int page, int size) {
    Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Order.desc("id")));
    return productRepository.findAll(pageable);
  }

  @Override
  public Products getProductById(Long productId) {
    return productRepository.findById(productId)
        .orElseThrow(() -> new NotFoundException("상품이 존재하지 않습니다."));
  }

  @Override
  public Page<Products> getProductsByCondition(String categoryId, String keyword,
      Integer pageNumber, Integer pageSize) {

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
