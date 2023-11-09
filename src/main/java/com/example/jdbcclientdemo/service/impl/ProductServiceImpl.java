package com.example.jdbcclientdemo.service.impl;

import com.example.jdbcclientdemo.entity.Product;
import com.example.jdbcclientdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private JdbcClient jdbcClient;
    @Override
    public List<Product> findAll() {
        return jdbcClient.
                sql("select * from product")
                .query(Product.class)
                .list();
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return jdbcClient.sql("select * from product where id = :id")
                .param("id",id)
                .query(Product.class)
                .optional();
    }

    @Override
    public void create(Product product) {
        Integer id  = product.getId();
        String name = product.getName();
        Double price = product.getPrice();
        Integer quantity  = product.getQuantity();
        jdbcClient.sql("INSERT INTO product (id,name,price,quantity) values(?,?,?,?) ")
                .params(List.of(id, name,price,quantity))
                .update();
    }

    @Override
    public void update(Product product, Integer id) {
        jdbcClient.sql("update product set name = ?, price = ?, quantity = ? where id = ?")
                .params(List.of(product.getName(),product.getPrice(),product.getQuantity(), id))
                .update();
    }

    @Override
    public void delete(Integer id) {
        jdbcClient.sql("delete from product where id = :id")
                .param("id", id)
                .update();
    }
}
