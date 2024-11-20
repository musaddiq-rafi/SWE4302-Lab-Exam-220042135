
package org.example;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<IFlavor> flavors;
    private List<IToppings> toppings;
    private boolean isWaffleCone;

    public Order(boolean isWaffleCone) {
        this.flavors = new ArrayList<>();
        this.toppings = new ArrayList<>();
        this.isWaffleCone = isWaffleCone;
    }

    public void addFlavor(IFlavor flavor) {
        this.flavors.add(flavor);
    }

    public void addToping(IToppings toping){
        this.toppings.add(toping);
    }

    public double calculateSubTotal(){
        double subtotal = isWaffleCone ? 5.00 : 0.00;
        for (IFlavor flavor : flavors) {
            subtotal += flavor.getPricePerScoop();
        }
        for (IToppings topping : toppings) {
            subtotal += topping.getPrice();
        }
        return subtotal;
    }

    public double getTax(){
        return calculateSubTotal() * 0.08;
    }

    public double calculateTotal(){
        return calculateSubTotal() + getTax();
    }

    public List<IFlavor> getFlavors() {
        return flavors;
    }

    public List<IToppings> getToppings() {
        return toppings;
    }

    public boolean isWaffleCone() {
        return isWaffleCone;
    }

    public void setWaffleCone(boolean waffleCone) {
        isWaffleCone = waffleCone;
    }
}