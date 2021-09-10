package com.dw.awsproject.service;

import com.dw.awsproject.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product getOne(int id);
    Product create(Product product);
}
