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

        // 1. Добавление продукта в корзину.
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);

        // 2. Добавление продукта в заполненную корзину.
        basket.addProduct(product6);

        // 3. Печать содержимого корзины с несколькими товарами.
        System.out.println("Содержимое корзины:");
        basket.printBasket();

        // 4. Получение стоимости корзины с несколькими товарами.
        System.out.println("Общая стоимость корзины: " + basket.getTotalCost());

        // 5. Поиск товара, который есть в корзине.
        System.out.println("Есть ли в корзине Яблоко: " + basket.containsProduct("Яблоко"));

        // 6. Поиск товара, которого нет в корзине.
        System.out.println("Есть ли в корзине Торт: " + basket.containsProduct("Торт"));

        // 7. Очистка корзины.
        basket.clearBasket();

        // 8. Печать содержимого пустой корзины.
        System.out.println("Содержимое пустой корзины:");
        basket.printBasket();

        // 9. Получение стоимости пустой корзины.
        System.out.println("Общая стоимость пустой корзины: " + basket.getTotalCost());

        // 10. Поиск товара по имени в пустой корзине.
        System.out.println("Есть ли в корзине Яблоко: " + basket.containsProduct("Яблоко"));
    }
}
