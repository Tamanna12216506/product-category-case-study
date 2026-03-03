package com.casestudy.productandcategory.service;

import com.casestudy.productandcategory.entity.Product;

import java.util.List;

public interface IProductService {
    Product createProduct(Product product, Integer categoryId);
    Product updateProduct(Integer id,Product product);
    Product getProductById(Integer id);
    List<Product> getAllProduct();
    List<Product> getProductByCategory(Integer categoryId);
    List<Product> getProductByName(String name);

    void deleteProduct(Integer id);
}
