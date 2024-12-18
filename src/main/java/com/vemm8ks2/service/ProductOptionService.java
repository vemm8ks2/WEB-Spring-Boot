package com.vemm8ks2.service;

import java.util.List;
import com.vemm8ks2.dto.request._ProductOptionDTO;
import com.vemm8ks2.model.ProductOptions;

public interface ProductOptionService {

  public ProductOptions createProductOption(ProductOptions productOption);

  public ProductOptions createProductOptionByDTO(_ProductOptionDTO productOptionDTO);

  public ProductOptions updateProductOptionStock(Long productOptionId, int stock);

  public ProductOptions getProductOptionById(Long productOptionId);

  public List<ProductOptions> getProductOptionsByProduct(Long productId);
}
