package com.casestudy.productandcategory.controller;

import com.casestudy.productandcategory.entity.Category;
import com.casestudy.productandcategory.service.CategoryService;
import com.casestudy.productandcategory.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final ICategoryService iCategoryService;

    @PostMapping("/post-category")
    public Category createCategory(@RequestBody Category category){
        return iCategoryService.createCategory(category);
    }

    @GetMapping("/{id}")
    public  Category readById(@PathVariable Integer id){
        return iCategoryService.getCategoryById(id);
    }

    @GetMapping("/all")
    public List<Category> readAll(){
        return  iCategoryService.getAllCategory();
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable Integer id, @RequestBody Category category){
        return iCategoryService.updateCategory(id,category);
    }

    @DeleteMapping("/{id}")
    public  void delete(@PathVariable Integer id){
        iCategoryService.deleteCategory(id);

    }
}
