package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final double cost;

    public SimpleProduct(String name, double cost) {
        super(name);

        if (cost <= 0) {
            throw new IllegalArgumentException("Cost must be greater than 0.");
        }

        this.cost = cost;
    }

    @Override
    public double getCost() {
        return cost;
    }
}