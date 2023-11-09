package com.example.jdbcclientdemo.controller;

import com.example.jdbcclientdemo.entity.Product;
import com.example.jdbcclientdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/products")
    List<Product> getProducts(){
      return   productService.findAll();
    }

    @GetMapping("/product/{id}")
   Optional<Product> getProduct(@PathVariable Integer id){
        return   productService.findById(id);
    }

    @PostMapping("/insertProduct")
    public void insertProduct(@RequestBody Product product){
        productService.create(product);
       // return "product with id " + product.getId() + " created successfully";
    }
    @PutMapping("/update/{id}")
    public void update(@RequestBody Product product, @PathVariable Integer  id){
        productService.update(product, id);
        // return "product with id " + product.getId() + " created successfully";
    }
    @DeleteMapping("/delete/{id}")
    public void insertProduct(@PathVariable Integer id ){
        productService.delete(id);
        // return "product with id " + product.getId() + " created successfully";
    }
}
