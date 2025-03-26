package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProductBasket {
    private final Map<String, List<Product>> products = new HashMap<>();

    public void addProduct(Product product) {
        String productName = product.getName();
        if (!products.containsKey(productName)) {
            products.put(productName, new ArrayList<>());
        }
        products.get(productName).add(product);

    }

    public double getTotalCost() {
        return products.values().stream()
                .flatMap(List::stream)
                .mapToDouble(Product::getCost)
                .sum();
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        double totalCost = getTotalCost();
        products.values().stream()
                .flatMap(List::stream)
                .forEach(System.out::println);

        System.out.println("Итого: " + totalCost);
        System.out.println("Специальных товаров: " + getSpecialCount());
    }

    private long getSpecialCount() {
        return products.values().stream()
                .flatMap(List::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public boolean containsProduct(String productName) {
        return products.containsKey(productName);
    }

    public void clearBasket() {
        products.clear();
    }
}