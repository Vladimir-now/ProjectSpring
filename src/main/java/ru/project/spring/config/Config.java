package ru.project.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.project.spring.entity.Cart;

import java.util.ArrayList;

@Configuration
public class Config {
    @Bean
    public Cart cart() {
        Cart cart = new Cart();
        cart.getContainer().put(1L, new ArrayList<>());
        cart.getContainer().put(2L, new ArrayList<>());
        cart.getContainer().put(3L, new ArrayList<>());
        cart.getContainer().put(4L, new ArrayList<>());
        return cart;
    }
}
