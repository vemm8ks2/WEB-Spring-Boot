package com.vemm8ks2.repository;

import org.springframework.data.jpa.domain.Specification;
import com.vemm8ks2.model.Category;
import com.vemm8ks2.model.Products;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;

public class ProductSpec {

  public static Specification<Products> hasTitle(String title) {
    return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("title"),
        "%" + title + "%");
  }

  public static Specification<Products> hasCategory(Long categoryId) {
    return (root, query, criteriaBuilder) -> {
      Join<Products, Category> joinedRoot = root.join("category", JoinType.INNER);
      return criteriaBuilder.equal(joinedRoot.get("category_id"), categoryId);
    };
  }
}
