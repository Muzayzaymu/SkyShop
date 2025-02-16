package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private double cost;

    public SimpleProduct(String name, double cost) {
        super(name);
        this.cost = cost;
    }

    @Override
    public double getCost() {
        return cost;
    }
}