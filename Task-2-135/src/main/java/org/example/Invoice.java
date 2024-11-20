package org.example;

import org.example.Order;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Invoice {
    public static void generateInvoice(Order order) throws IOException {
        double subtotal = order.calculateSubTotal();
        double total = order.calculateTotal();
        HashMap<String, Integer> flavorCount = new HashMap<>();
        HashMap<String, Integer> toppingCount = new HashMap<>();

        for (Flavor flavor : order.getFlavors()) {
            flavorCount.put(flavor.getName(), flavorCount.getOrDefault(flavor.getName(), 0) + 1);
        }
        for (Toppings topping : order.getToppings()) {
            toppingCount.put(topping.getName(), toppingCount.getOrDefault(topping.getName(), 0) + 1);
        }

        try (FileWriter writer = new FileWriter("Invoice.txt")) {
            writer.write("Ice Cream Shop Invoice\n");
            for (String flavor : flavorCount.keySet()) {
                writer.write(flavor + " - " + flavorCount.get(flavor) + " scoop(s): $" +
                        String.format("%.2f", flavorCount.get(flavor) * 2.80) + "\n");
            }
            for (String topping : toppingCount.keySet()) {
                writer.write(topping + " - " + toppingCount.get(topping) + " time(s): $" +
                        String.format("%.2f", toppingCount.get(topping) * 0.50) + "\n");
            }
            writer.write("Subtotal: $" + String.format("%.2f", subtotal) + "\n");
            writer.write("Tax: $" + String.format("%.2f", subtotal * 0.08) + "\n");
            writer.write("Total Amount Due: $" + String.format("%.2f", total) + "\n");
        }
    }
}
