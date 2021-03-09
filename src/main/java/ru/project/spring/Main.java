package ru.project.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.project.spring.config.Config;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        var scanner = new Scanner(System.in);
        Cart cart = context.getBean("cart", Cart.class);
        ProductRepository repository = context.getBean("productRepository", ProductRepository.class);

        String commandLine;

        System.out.println("Команды:");
        System.out.println("add id - добавить товар в корзину по ид\n" +
                "delete id - удалить товар из корзины по ид\n" +
                "showcart - показать товары в корзине\n" +
                "show id - показать товар из списка по ид\n" +
                "showitems - показать все товары в списке\n" +
                "end - выход");

        while (true) {
            commandLine = scanner.nextLine();
            String[] str = commandLine.split(" ");
            int id;
            if (str[0].equalsIgnoreCase("add")) {
                id = Integer.parseInt(str[1]);
                cart.addProduct(repository.getProduct(id));
            } else if (str[0].equalsIgnoreCase("delete")) {
                id = Integer.parseInt(str[1]);
                cart.deleteProduct(id);
            } else if (str[0].equalsIgnoreCase("showcart")) {
                cart.showShopCart();
            } else if (str[0].equalsIgnoreCase("show")) {
                id = Integer.parseInt(str[1]);
                repository.showProduct(id);
            } else if (str[0].equalsIgnoreCase("showitems")) {
                repository.showProducts();
            }

            if (str[0].equalsIgnoreCase("end")) break;
        }
    }


}
