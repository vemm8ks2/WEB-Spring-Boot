package com.vemm8ks2.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.vemm8ks2.dto.request._ProductOptionDTO;
import com.vemm8ks2.exception.NotFoundException;
import com.vemm8ks2.model.ProductOptions;
import com.vemm8ks2.model.Products;
import com.vemm8ks2.repository.ProductOptionRepository;
import com.vemm8ks2.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductOptionServiceImpl implements ProductOptionService {

  private final ProductOptionRepository productOptionRepository;
  private final ProductRepository productRepository;

  @Override
  public ProductOptions createProductOption(ProductOptions productOption) {
    return productOptionRepository.save(productOption);
  }

  @Override
  public ProductOptions createProductOptionByDTO(_ProductOptionDTO productOptionDTO) {

    Products product = productRepository.findById(productOptionDTO.getProductId())
        .orElseThrow(() -> new NotFoundException("상품이 존재하지 않습니다."));

    ProductOptions _productOption = new ProductOptions();

    _productOption.setSize(productOptionDTO.getSize());
    _productOption.setStock(productOptionDTO.getStock());
    _productOption.setProduct(product);

    return productOptionRepository.save(_productOption);
  }

  @Override
  @Transactional
  public ProductOptions updateProductOptionStock(Long productOptionId, int stock) {

    if (stock < 0) {
      throw new IllegalArgumentException("올바른 재고를 입력해주세요.");
    }

    ProductOptions productOptions = getProductOptionById(productOptionId);

    productOptions.setStock(stock);

    return productOptionRepository.save(productOptions);
  }

  @Override
  public ProductOptions getProductOptionById(Long productOptionId) {
    return productOptionRepository.findById(productOptionId)
        .orElseThrow(() -> new NotFoundException("상품 옵션을 찾을 수 없습니다."));
  }

  @Override
  public List<ProductOptions> getProductOptionsByProduct(Long productId) {
    return productOptionRepository.findByProductId(productId);
  }

}
