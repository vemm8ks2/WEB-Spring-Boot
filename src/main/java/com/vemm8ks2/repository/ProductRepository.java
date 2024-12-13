package com.vemm8ks2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.vemm8ks2.model.Products;

public interface ProductRepository
    extends JpaRepository<Products, Long>, JpaSpecificationExecutor<Products> {

}
