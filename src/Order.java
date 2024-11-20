import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Flavor> flavors = new ArrayList<>();
    private List<Integer> flavorCounts = new ArrayList<>();
    private List<Topping> toppings = new ArrayList<>();
    private List<Integer> toppingCounts = new ArrayList<>();
    private boolean isWaffleCone;
    private final double WAFFLE_CONE_PRICE = 5.00;
    private final double TAX_RATE = 0.08;

    public void addFlavor(Flavor flavor, int count) {
        flavors.add(flavor);
        flavorCounts.add(count);
    }

    public void addTopping(Topping topping, int count) {
        toppings.add(topping);
        toppingCounts.add(count);
    }

    public void setServingStyle(boolean isWaffleCone) {
        this.isWaffleCone = isWaffleCone;
    }

    public double calculateSubtotal() {
        double subtotal = 0;
        for (int i = 0; i < flavors.size(); i++) {
            subtotal += flavors.get(i).price * flavorCounts.get(i);
        }
        for (int i = 0; i < toppings.size(); i++) {
            subtotal += toppings.get(i).price * toppingCounts.get(i);
        }
        if (isWaffleCone) {
            subtotal += WAFFLE_CONE_PRICE;
        }
        return subtotal;
    }

    public double calculateTax() {
        return calculateSubtotal() * TAX_RATE;
    }

    public double calculateTotal() {
        return calculateSubtotal() + calculateTax();
    }

    public void generateInvoice(String filename) throws IOException {
        FileWriter writer = new FileWriter(filename);
        writer.write("Ice Cream Shop Invoice\n");
        for (int i = 0; i < flavors.size(); i++) {
            writer.write(flavors.get(i).name + " - " + flavorCounts.get(i) + " scoop(s): $" +
                    String.format("%.2f", flavors.get(i).price * flavorCounts.get(i)) + "\n");
        }
        for (int i = 0; i < toppings.size(); i++) {
            writer.write(toppings.get(i).name + " - " + toppingCounts.get(i) + " time(s): $" +
                    String.format("%.2f", toppings.get(i).price * toppingCounts.get(i)) + "\n");
        }
        writer.write("Subtotal: $" + String.format("%.2f", calculateSubtotal()) + "\n");
        writer.write("Tax: $" + String.format("%.2f", calculateTax()) + "\n");
        writer.write("Total Amount Due: $" + String.format("%.2f", calculateTotal()) + "\n");
        writer.close();
    }
}
