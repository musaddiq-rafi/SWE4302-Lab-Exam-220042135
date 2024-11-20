package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {

    @Test
    public void testCalculateTotalWithWaffleCone() {
        Order order = new Order(true);
        order.addFlavor(new Flavor("Mint Chocolate Chip", 2.80));
        order.addFlavor(new Flavor("Chocolate Fudge", 3.00));
        order.addToping(new Toppings("Sprinkles", 0.30));
        order.addToping(new Toppings("Marshmallow", 0.70));

        double expectedTotal = 12.74;
        assertEquals(expectedTotal, order.calculateTotal(), 0.01);
    }

    @Test
    public void testCalculateTotalWithoutWaffleCone() {
        Order order = new Order(false);
        order.addFlavor(new Flavor("Strawberry Swirl", 2.75));
        order.addFlavor(new Flavor("Pistachio Delight", 3.25));
        order.addToping(new Toppings("Crushed Oreo", 0.85));
        order.addToping(new Toppings("Fresh Strawberries", 1.00));

        double expectedTotal = 8.47;
        assertEquals(expectedTotal, order.calculateTotal(), 0.01);
    }

    @Test
    public void testAddFlavor() {
        Order order = new Order(false);
        Flavor flavor = new Flavor("Pistachio Delight", 3.25);
        order.addFlavor(flavor);
        assertEquals(1, order.getFlavors().size());
        assertEquals(flavor, order.getFlavors().get(0));
    }

    @Test
    public void testAddTopping() {
        Order order = new Order(false);
        Toppings topping = new Toppings("Marshmallow", 0.70);
        order.addToping(topping);
        assertEquals(1, order.getToppings().size());
        assertEquals(topping, order.getToppings().get(0));
    }

    @Test
    public void testCalculateSubTotal() {
        Order order = new Order(true);
        order.addFlavor(new Flavor("Mint Chocolate Chip", 2.80));
        order.addFlavor(new Flavor("Chocolate Fudge", 3.00));
        order.addToping(new Toppings("Sprinkles", 0.30));
        order.addToping(new Toppings("Marshmallow", 0.70));

        double expectedSubTotal = 11.80;
        assertEquals(expectedSubTotal, order.calculateSubTotal(), 0.01);
    }
}