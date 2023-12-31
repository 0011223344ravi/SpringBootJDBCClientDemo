package com.example.jdbcclientdemo.service;

import com.example.jdbcclientdemo.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();

    Optional<Product> findById(Integer id);

    void create(Product product);

    void update(Product product, Integer id);

    void delete(Integer id);
}
