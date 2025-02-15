package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product product1 = new Product("Яблоко", 50);
        Product product2 = new Product("Молоко", 100);
        Product product3 = new Product("Хлеб", 40);
        Product product4 = new Product("Сыр", 200);
        Product product5 = new Product("Печенье", 80);
        Product product6 = new Product("Торт", 300);


        ProductBasket basket = new ProductBasket();

        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);

        basket.addProduct(product6);

        System.out.println("Содержимое корзины:");
        basket.printBasket();

        System.out.println("Общая стоимость корзины: " + basket.getTotalCost());

        System.out.println("Есть ли в корзине Яблоко: " + basket.containsProduct("Яблоко"));

        System.out.println("Есть ли в корзине Торт: " + basket.containsProduct("Торт"));

        basket.clearBasket();

        System.out.println("Содержимое пустой корзины:");
        basket.printBasket();

        System.out.println("Общая стоимость пустой корзины: " + basket.getTotalCost());

        System.out.println("Есть ли в корзине Яблоко: " + basket.containsProduct("Яблоко"));
    }
}
