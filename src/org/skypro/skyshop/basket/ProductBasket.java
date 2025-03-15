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
        double totalCost = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                totalCost += product.getCost();
            }
        }
        return totalCost;
    }

    public void printBasket() {
        double totalCost = 0;
        int specialProductsCount = 0;

        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                System.out.println(product.toString());
                totalCost += product.getCost();
                if (product.isSpecial()) {
                    specialProductsCount++;
                }
            }
        }

        System.out.println("Итого: " + totalCost);
        System.out.println("Специальных товаров: " + specialProductsCount);
    }

    public boolean containsProduct(String productName) {
        return products.containsKey(productName);
    }

    public void clearBasket() {
        products.clear();
    }
}