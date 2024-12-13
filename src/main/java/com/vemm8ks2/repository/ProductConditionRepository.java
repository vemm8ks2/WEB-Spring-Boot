package com.vemm8ks2.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.vemm8ks2.model.Category;
import com.vemm8ks2.model.Products;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ProductConditionRepository {

  private final EntityManager entityManager;

  public List<Products> findProductsByCondition(Long categoryId, String keyword) {
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();

    CriteriaQuery<Products> query = builder.createQuery(Products.class);
    Root<Products> root = query.from(Products.class);
    
    Join<Products, Category> joinedRoot = root.join("category", JoinType.INNER);

    List<Predicate> predicates = new ArrayList<>();

    if (categoryId != null) {
      Predicate predicate = builder.equal(joinedRoot.get("category_id"), root);
      predicates.add(predicate);
    }
    
    if (keyword != null) {
      Predicate predicate = builder.like(joinedRoot.get("title"), "%" + keyword +"%");
      predicates.add(predicate);
    }
    
    query.where(builder.and(predicates.toArray(new Predicate[0])));

    return entityManager.createQuery(query).getResultList();
  }
}
