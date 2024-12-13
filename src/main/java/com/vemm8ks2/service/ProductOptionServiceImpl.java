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
public class ProductOptionServiceImpl implements ProductOptionService {

  private final ProductOptionRepository productOptionRepository;

  @Override
  public ProductOptions createProductOption(ProductOptions productOption) {
    return productOptionRepository.save(productOption);
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
