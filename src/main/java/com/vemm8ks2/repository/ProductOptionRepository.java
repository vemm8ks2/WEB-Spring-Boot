package com.vemm8ks2.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.vemm8ks2.model.ProductOptions;

public interface ProductOptionRepository extends JpaRepository<ProductOptions, Long> {

  public List<ProductOptions> findByProductId(Long productId);
}
