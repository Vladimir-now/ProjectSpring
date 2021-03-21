package ru.project.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import ru.project.spring.Cart;
import ru.project.spring.Product;
import ru.project.spring.ProductRepository;

@EnableWebMvc
@Configuration
@ComponentScan("ru.project.spring")
public class Config implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setTemplateEngine(templateEngine());
        return viewResolver;
    }

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
