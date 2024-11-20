package org.example;

public class Flavor implements IFlavor {
    private final String name;
    private final double pricePerScoop;

    public Flavor(String name, double pricePerScoop) {
        this.name = name;
        this.pricePerScoop = pricePerScoop;
    }
    public String getName() {
        return name;
    }

    public double getPricePerScoop() {
        return pricePerScoop;
    }
}

