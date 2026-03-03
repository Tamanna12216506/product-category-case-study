package com.casestudy.productandcategory.repository;

import com.casestudy.productandcategory.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
}
