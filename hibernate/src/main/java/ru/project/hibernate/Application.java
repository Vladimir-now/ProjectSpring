package ru.project.hibernate;

import ru.project.hibernate.dao.ProductDAO;
import ru.project.hibernate.entity.Product;

public class Application {
    public static void main(String[] args) {

        ProductDAO dao = ProductDAO.getInstance();

        Product product = new Product("potato", 15);

        System.out.println(dao.findById(4L));

        dao.getSession().close();
    }
}
