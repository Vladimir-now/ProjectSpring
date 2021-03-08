package ru.project.spring;

import java.util.List;

public class ProductRepository {

    private List<Product> repository;

    public List<Product> getRepository() {
        return repository;
    }

    public void addProduct(Product product) {
        repository.add(product);
    }
}
