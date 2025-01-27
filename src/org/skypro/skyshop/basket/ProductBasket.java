package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private final Product[] products = new Product[5];
    private int productCount = 0;

    public void addProduct(Product product) {
        if (productCount < products.length) {
            products[productCount] = product;
            productCount++;
        } else {
            System.out.println("Невозможно добавить продукт");
        }
    }

    public int getTotalCost() {
        int totalCost = 0;
        for (Product product : products) {
            if (product != null) {
                totalCost += product.getCost();
            }
        }
        return totalCost;
    }


    public void printBasket() {
        if (productCount == 0) {
            System.out.println("В корзине пусто");
            return;
        }
        for (Product product : products) {
            if(product != null){
                System.out.println(product.getName() + ": " + product.getCost());
            }
        }
        System.out.println("Итого: " + getTotalCost());
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
        Arrays.fill(products, null);
        productCount = 0;
    }
}