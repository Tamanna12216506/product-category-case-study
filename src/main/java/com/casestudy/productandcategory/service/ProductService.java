package com.casestudy.productandcategory.service;

import com.casestudy.productandcategory.entity.Category;
import com.casestudy.productandcategory.entity.Product;
import com.casestudy.productandcategory.exception.CategoryNotFoundException;
import com.casestudy.productandcategory.exception.ProductNotFoundException;
import com.casestudy.productandcategory.repository.CategoryRepo;
import com.casestudy.productandcategory.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductService implements IProductService{
    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;
    @Override
    public Product createProduct(Product product, Integer categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(()->new CategoryNotFoundException("Category not found"));
        product.setCategory(category);
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(Integer id, Product product) {
        Product exits = getProductById(id);
        exits.setProductName(product.getProductName());
        exits.setCategory(product.getCategory());
        exits.setPrice(product.getPrice());
        return productRepo.save(exits);

    }

    @Override
    public Product getProductById(Integer id) {
        return productRepo.findById(id).orElseThrow(()->new ProductNotFoundException("Product not found"));
    }

    @Override
    public List<Product> getAllProduct() {

        return productRepo.findAll();
    }

    @Override
    public List<Product> getProductByCategory(Integer categoryId) {
        if(!categoryRepo.existsById(categoryId)){
            throw new CategoryNotFoundException("Category not found with id "+categoryId);
        }
        return productRepo.findByCategory_CategoryId(categoryId);
    }

    @Override
    public List<Product> getProductByName(String name) {
        return productRepo.findByProductName(name);
    }

    @Override
    public void deleteProduct(Integer id) {
        Product p = getProductById(id);
        productRepo.delete(p);
    }
}
