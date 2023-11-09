package com.example.jdbcclientdemo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.message.AsynchronouslyFormattable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    private Integer id ;
    private String name ;
    private Double price;
    private Integer quantity;
}
