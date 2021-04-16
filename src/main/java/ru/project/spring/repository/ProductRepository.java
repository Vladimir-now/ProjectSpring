package ru.project.spring.repository;

import org.springframework.data.repository.CrudRepository;
import ru.project.spring.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
