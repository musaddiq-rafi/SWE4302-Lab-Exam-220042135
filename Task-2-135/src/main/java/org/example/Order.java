package org.example;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Flavor> flavors;
    private List<Toppings> toppings;
    private boolean isWaffleCone;

    public Order(boolean isWaffleCone) {
        this.flavors = new ArrayList<>();
        this.toppings = new ArrayList<>();
        this.isWaffleCone = isWaffleCone;
    }
    public void addFlavor(Flavor flavor) {
        this.flavors.add(flavor);
    }
    public void addToping(Toppings toping){
        this.toppings.add(toping);
    }

    public double calculateSubTotal(){
        double subtotal=0;
        if(isWaffleCone()){
             subtotal= 5.00;
        }
        else{
             subtotal= 0.00;
        }
        for (Flavor flavor : flavors) {
            subtotal += flavor.getPricePerScoop();
        }
        for (Toppings topping : toppings) {
            subtotal += topping.getPrice();
        }
        return subtotal;
    }

    public double calculateTotal() {
            double subtotal = calculateSubTotal();
            double tax = 0.08;
            return subtotal + (subtotal * tax);
    }

    public List<Flavor> getFlavors() {
        return flavors;
    }

    public void setFlavors(List<Flavor> flavors) {
        this.flavors = flavors;
    }

    public List<Toppings> getToppings() {
        return toppings;
    }

    public void setToppings(List<Toppings> toppings) {
        this.toppings = toppings;
    }

    public boolean isWaffleCone() {
        return isWaffleCone;
    }

    public void setWaffleCone(boolean waffleCone) {
        isWaffleCone = waffleCone;
    }
}
