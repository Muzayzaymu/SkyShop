package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private  double baseCost;
    private  int discountPercentage;

    public DiscountedProduct(String name, double baseCost, int discountPercentage) {
        super(name);
        this.baseCost = baseCost;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double getCost() {
        return baseCost * (1 - (double) discountPercentage / 100);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + ": " + getCost() + " (" + discountPercentage + "%)";
    }
}