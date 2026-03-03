package com.casestudy.productandcategory.repository;
import com.casestudy.productandcategory.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Integer> {
    List<Product> findByCategory_CategoryId(Integer categoryId);

    List<Product> findByProductName(String name);
}
