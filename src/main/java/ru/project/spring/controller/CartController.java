package ru.project.spring.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.project.spring.entity.Cart;
import ru.project.spring.entity.Product;
import ru.project.spring.repository.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("cart/{customerId}")
@RequiredArgsConstructor
public class CartController {

    private final Cart cart;
    private final ProductRepository productRepository;


    @GetMapping
    @ApiOperation("Показываем корзину пользователя")
    public List<Product> getCustomerProducts(@PathVariable Long customerId) {
        return cart.getContainer().get(customerId);
    }

    @PostMapping("{productId}")
    @ApiOperation("Добавляем продукт в корзину пользователя")
    public List<Product> addProduct(@PathVariable Long customerId, @PathVariable Long productId) {
        cart.addProduct(customerId, productRepository.findById(productId).get());
        return cart.getContainer().get(customerId);
    }

    @DeleteMapping("{productId}")
    @ApiOperation("Удаляем продукт из корзины пользователя")
    public List<Product> deleteProduct(@PathVariable Long customerId, @PathVariable Long productId) {
        cart.deleteProduct(customerId, productId);
        return cart.getContainer().get(customerId);
    }
}
