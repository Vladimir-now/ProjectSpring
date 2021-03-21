package ru.project.spring;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {

    private final List<Product> shopCart = new ArrayList<>();
    private int count = 0;

    public void addProduct(Product product) {
        shopCart.add(product);
        count++;
        System.out.println("В корзину добавлен: " + product.getName() + "\n" +
                "Товаров в корзине: " + count);
    }

    public void deleteProduct(int id) {
        var product = shopCart.stream().filter(x -> x.getId()==id).findFirst().get();
        shopCart.remove(product);
        count--;
        System.out.println("Из корзины удален: " + product.getName() + "\n" +
                "Товаров в корзине: " + count);
    }

    public void showShopCart() {
        if (shopCart.size() == 0) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println("Товары в корзине:");
            shopCart.forEach(System.out::println);
        }
    }
}
