package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixCostProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        basket.addProduct(new SimpleProduct("Яблоко", 100.0));
        basket.addProduct(new DiscountedProduct("Банан со скидкой", 150.0, 10));
        basket.addProduct(new FixCostProduct("Жвачка"));
        basket.addProduct(new SimpleProduct("Апельсин", 120.0));
        basket.addProduct(new DiscountedProduct("Шоколад со скидкой", 200.0, 20));

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
