package com.casestudy.productandcategory.controller;

import com.casestudy.productandcategory.entity.Product;
import com.casestudy.productandcategory.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final IProductService iProductService;

    @PostMapping("/add-product/{categoryId}")
    /// creating product and assigning to category
    public Product createProduct(@RequestBody Product product, @PathVariable Integer categoryId) {
        return iProductService.createProduct(product, categoryId);
    }

    @GetMapping("/{id}")
    public  Product getById(@PathVariable Integer id){
        return iProductService.getProductById(id);
    }
    @GetMapping("/all")
    public List<Product> readAll(){
        return iProductService.getAllProduct();
    }
    @GetMapping("/category/{categoryId}")
    public List<Product> byCategory(@PathVariable Integer categoryId){
        return iProductService.getProductByCategory(categoryId);
    }

    @GetMapping("/serach")
    public  List<Product> searchProduct(@RequestBody String name){
        return  iProductService.getProductByName(name);
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable Integer id,@RequestBody Product product){
        return iProductService.updateProduct(id,product);
    }
    @DeleteMapping("/{id}")
    public  void deleteProd(@PathVariable Integer id){
        iProductService.deleteProduct(id);
    }
}