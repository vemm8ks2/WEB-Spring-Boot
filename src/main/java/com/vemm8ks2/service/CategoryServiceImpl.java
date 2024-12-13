package com.vemm8ks2.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.vemm8ks2.exception.NotFoundException;
import com.vemm8ks2.model.Category;
import com.vemm8ks2.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

  private final CategoryRepository categoryRepository;

  @Override
  public Category createCategory(Category category) {

    Category _category = new Category();

    _category.setName(category.getName());
    _category.setLevel(getCategoryById(category.getParentCategory().getId()).getLevel() + 1);
    _category.setParentCategory(category.getParentCategory());

    return categoryRepository.save(_category);
  }

  @Override
  public Category getCategoryById(Long categoryId) {
    return categoryRepository.findById(categoryId)
        .orElseThrow(() -> new NotFoundException("카테고리가 존재하지 않습니다."));
  }

  @Override
  public List<Category> getCategoriesByParentCategory(Long parentCategoryId) {
    return categoryRepository.findByParentCategoryId(parentCategoryId);
  }

}
