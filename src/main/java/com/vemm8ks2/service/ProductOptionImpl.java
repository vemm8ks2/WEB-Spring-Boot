package com.vemm8ks2.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.vemm8ks2.exception.NotFoundException;
import com.vemm8ks2.model.ProductOptions;
import com.vemm8ks2.repository.ProductOptionRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductOptionImpl implements ProductOptionService {

  private final ProductOptionRepository productOptionRepository;

  @Override
  public ProductOptions createProductOption(ProductOptions productOption) {

    ProductOptions _productOptions = new ProductOptions();

    _productOptions.setSize(productOption.getSize());
    _productOptions.setStock(productOption.getStock());
    _productOptions.setProduct(productOption.getProduct());

    return productOptionRepository.save(_productOptions);
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
