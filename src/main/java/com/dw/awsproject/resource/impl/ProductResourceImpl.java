package com.dw.awsproject.resource.impl;

import com.dw.awsproject.domain.Product;
import com.dw.awsproject.resource.ProductResource;
import com.dw.awsproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductResourceImpl implements ProductResource {

    @Autowired
    private ProductService service;

    @Override
    @GetMapping
    public List<Product> getAll() {
        return this.service.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public Product getOne(@PathVariable int id) {
        return this.service.getOne(id);
    }

    @Override
    @PutMapping("/{id}/add")
    public Product create(@PathVariable int id, @RequestBody Product product) {
        return this.service.create(product);
    }
}
