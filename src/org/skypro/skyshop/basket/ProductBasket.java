package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductBasket {
    private final List<Product> products = new ArrayList<>();


    public void addProduct(Product product) {
        products.add(product);
    }

    public int getTotalCost() {
        int totalCost = 0;
        for (Product product : products) {
            if (product != null) {
                totalCost += (int) product.getCost();
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

        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
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
        for (Product product : products) {
            if (product != null && product.getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }


    public void clearBasket() {
        products.clear();
    }

    public List<Product> removeProduct(String name) {
        List<Product> removedProducts = new ArrayList<>();
        products.removeIf(product -> {
            if (product.getName().equals(name)) {
                removedProducts.add(product);
                return true;
            }
            return false;
        });
        return removedProducts;
    }
}