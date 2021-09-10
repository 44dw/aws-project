package com.dw.awsproject.resource;

import com.dw.awsproject.domain.Product;

import java.util.List;

public interface ProductResource {
    List<Product> getAll();
    Product getOne(int id);
    Product create(int id, Product product);
}
