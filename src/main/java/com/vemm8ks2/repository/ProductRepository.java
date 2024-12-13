package com.vemm8ks2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vemm8ks2.model.Products;

public interface ProductRepository extends JpaRepository<Products, Long> {

}
