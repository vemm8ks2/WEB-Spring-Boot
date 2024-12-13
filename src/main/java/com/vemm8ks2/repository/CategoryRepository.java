package com.vemm8ks2.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.vemm8ks2.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

  public List<Category> findByParentCategoryId(Long id);
}
