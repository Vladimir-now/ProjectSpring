package ru.project.spring.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Cart {
    private static HashMap<Long, List<Product>> container;

    public Cart() {
        container = new HashMap<>();
    }

    public HashMap<Long, List<Product>> getContainer() {
        return container;
    }

    public void addProduct(Long customerId, Product product) {
        var newList = container.get(customerId);
        newList.add(product);
        container.put(customerId, newList);
    }

    public void deleteProduct(Long customerId, Long productId) {
        var newList = container.get(customerId);
        Optional<Product> findProduct = newList.stream().filter(x -> x.getId().equals(productId)).findFirst();
        findProduct.ifPresent(newList::remove);
        container.put(customerId, newList);
    }
}
