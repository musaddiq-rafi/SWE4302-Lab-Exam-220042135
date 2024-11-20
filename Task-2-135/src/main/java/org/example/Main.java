package org.example;


import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Flavor mintChocolateChip = new Flavor("Mint Chocolate Chip", 2.80);
        Flavor chocolateFudge = new Flavor("Chocolate Fudge", 3.00);
        Toppings sprinkles = new Toppings("Sprinkles", 0.30);
        Toppings marshmallow = new Toppings("Marshmallow", 0.70);

        Order order = new Order(true);
        order.addFlavor(mintChocolateChip);
        order.addFlavor(chocolateFudge);
        order.addToping(sprinkles);
        order.addToping(marshmallow);

        System.out.println("Subtotal: $" + order.calculateSubTotal());
        System.out.println("Tax: $" + order.getTax());
        System.out.println("Total: $" + order.calculateTotal());

        try {
            Invoice.generateInvoice(order);
            System.out.println("Invoice generated: Invoice.txt");
        } catch (IOException e) {
            System.err.println("Error generating invoice: " + e.getMessage());
        }
    }
}
