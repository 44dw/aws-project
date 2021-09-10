package com.dw.awsproject.service.impl;

import com.dw.awsproject.domain.Product;
import com.dw.awsproject.exception.EntityNotFoundException;
import com.dw.awsproject.service.ProductService;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Faker faker = new Faker();
    private final List<Product> products = new CopyOnWriteArrayList<>(ProductServiceImpl.generateTestData());

    private static List<Product> generateTestData() {
        return Collections.singletonList(
                new Product(1, faker.book().title())
        );
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product getOne(int id) {
        Optional<Product> first = products.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
        return first.orElseThrow(() -> new EntityNotFoundException(String.format("Entity with id %s not found", id)));
    }

    @Override
    public Product create(Product product) {
        products.add(product);
        return product;
    }
}
