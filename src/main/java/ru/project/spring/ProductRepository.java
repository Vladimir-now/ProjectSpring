package ru.project.spring;

import ru.project.spring.entity.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


public class ProductRepository {

    private final List<Product> repository = new ArrayList<>();

    public List<Product> getRepository() {
        return repository;
    }

    public void addProduct(Product product) {
        repository.add(product);
    }

    public void showProduct(int id) {
        System.out.println(repository.stream().filter(x -> x.getId() == id));
    }

    public void showProducts() {
        repository.forEach(System.out::println);
    }

    public Product getProduct(int id) {
        return repository.stream().filter(x -> x.getId() == id).findFirst().get();
    }

    @PostConstruct
    private void run() {
        repository.add(new Product(1, "Cucumber", 121.5));
        repository.add(new Product(2, "Apple", 99.0));
        repository.add(new Product(3, "Tomato", 155.0));
        repository.add(new Product(4, "Onion", 31.5));
        repository.add(new Product(5, "Paprika", 255.5));
    }
}
