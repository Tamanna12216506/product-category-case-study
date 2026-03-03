package com.casestudy.productandcategory.service;

import com.casestudy.productandcategory.entity.Category;
import com.casestudy.productandcategory.exception.CategoryNotFoundException;
import com.casestudy.productandcategory.repository.CategoryRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService{
    private  final CategoryRepo categoryRepo;
    @Override
    public Category createCategory(Category category) {

        return categoryRepo.save(category);
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryRepo.findById(id).orElseThrow(()->new CategoryNotFoundException("Category not found"));
    }

    @Override
    public List<Category> getAllCategory() {

        return categoryRepo.findAll();
    }

    @Override
    public Category updateCategory(Integer id, Category category) {
        Category exist = getCategoryById(id);
        exist.setCategoryName(category.getCategoryName());
        exist.setDesc(category.getDesc());
        return  categoryRepo.save(exist);
    }

    @Override
    public void deleteCategory(Integer id) {
        Category exist = getCategoryById(id);
        categoryRepo.delete(exist);
    }
}
