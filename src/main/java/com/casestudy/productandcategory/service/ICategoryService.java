package com.casestudy.productandcategory.service;

import com.casestudy.productandcategory.entity.Category;

import java.util.List;

public interface ICategoryService {
    Category createCategory(Category category);
    Category getCategoryById(Integer id);
    List<Category> getAllCategory();
    Category updateCategory(Integer id,Category category);
    void deleteCategory(Integer id);
}
