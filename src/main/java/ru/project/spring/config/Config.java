package ru.project.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.project.spring.Cart;
import ru.project.spring.Product;
import ru.project.spring.ProductRepository;

@Configuration
@ComponentScan("ru.project.spring")
public class Config implements WebMvcConfigurer {

    @Bean(name = "productRepository")
    public ProductRepository productRepository() {
        ProductRepository repository = new ProductRepository();
        repository.addProduct(new Product(1, "Cucumber", 121.5));
        repository.addProduct(new Product(2, "Apple", 99.0));
        repository.addProduct(new Product(3, "Tomato", 155.0));
        repository.addProduct(new Product(4, "Onion", 31.5));
        repository.addProduct(new Product(5, "Paprika", 255.5));
        return repository;
    }

    @Bean(name = "cart")
    public Cart cart() {
        return new Cart();
    }

}
