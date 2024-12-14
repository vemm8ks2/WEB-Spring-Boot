package com.vemm8ks2.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vemm8ks2.model.Category;
import com.vemm8ks2.service.CategoryService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/public/category")
@RequiredArgsConstructor
public class CategoryController {

  private final CategoryService categoryService;

  @GetMapping
  public List<Category> getAllCategory() {
    return categoryService.getAllCategories();
  }
}
