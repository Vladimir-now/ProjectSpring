package ru.project.spring;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("productRepository")
public class ProductRepository {

    private final List<Product> repository = new ArrayList<>();

    public List<Product> getRepository() {
        return repository;
    }

    public void addProduct(Product product) {
        repository.add(product);
    }

    public void showProduct(int id) {
        System.out.println(repository.stream().filter(x -> x.getId()==id));
    }

    public void showProducts() {
       repository.forEach(System.out::println);
    }

    public Product getProduct(int id) {
        return repository.stream().filter(x -> x.getId()==id).findFirst().get();
    }
}
