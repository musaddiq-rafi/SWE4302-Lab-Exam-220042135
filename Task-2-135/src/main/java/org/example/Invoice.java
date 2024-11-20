package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Invoice {

    public static void generateInvoice(Order order) throws IOException {
        double subtotal = order.calculateSubTotal();
        double total = order.calculateTotal();


        HashMap<String, Integer> flavorCount = new HashMap<>();
        HashMap<String, Integer> toppingCount = new HashMap<>();

        order.getFlavors().forEach(flavor ->
                flavorCount.put(flavor.getName(), flavorCount.getOrDefault(flavor.getName(), 0) + 1)
        );

        order.getToppings().forEach(topping ->
                toppingCount.put(topping.getName(), toppingCount.getOrDefault(topping.getName(), 0) + 1)
        );


        try (FileWriter writer = new FileWriter("Invoice.txt")) {
            writer.write("Ice Cream Shop Invoice\n");


            for (String flavor : flavorCount.keySet()) {
                double pricePerScoop = 0;
                for (IFlavor f : order.getFlavors()) {
                    if (f.getName().equals(flavor)) {
                        pricePerScoop = f.getPricePerScoop();
                        break;
                    }
                }
                int count = flavorCount.get(flavor);
                writer.write(String.format("%s - %d scoop(s): $%.2f\n", flavor, count, count * pricePerScoop));
            }


            for (String topping : toppingCount.keySet()) {
                double pricePerTopping = 0;
                for (IToppings t : order.getToppings()) {
                    if (t.getName().equals(topping)) {
                        pricePerTopping = t.getPrice();
                        break;
                    }
                }
                int count = toppingCount.get(topping);
                writer.write(String.format("%s - %d time(s): $%.2f\n", topping, count, count * pricePerTopping));
            }


            writer.write(String.format("Subtotal: $%.2f\n", subtotal));
            writer.write(String.format("Tax: $%.2f\n", subtotal * 0.08));
            writer.write(String.format("Total Amount Due: $%.2f\n", total));
        }
    }
}