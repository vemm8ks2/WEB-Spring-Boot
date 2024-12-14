package com.vemm8ks2.service;

import java.util.List;
import com.vemm8ks2.model.Category;

public interface CategoryService {

  public Category createCategory(Category category);

  public Category getCategoryById(String categoryId);

  public List<Category> getCategoriesByParentCategory(Category parentCategory);

  public List<Category> getAllCategories();
}
