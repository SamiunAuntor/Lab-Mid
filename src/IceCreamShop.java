import java.util.Scanner;

public class IceCreamShop {
    public static void main(String[] args) {
        Flavor mint = new Flavor("Mint Chocolate Chip", 2.80);
        Flavor fudge = new Flavor("Chocolate Fudge", 3.00);
        Flavor strawberry = new Flavor("Strawberry Swirl", 2.75);
        Flavor pistachio = new Flavor("Pistachio Delight", 3.25);

        Topping sprinkles = new Topping("Sprinkles", 0.30);
        Topping marshmallow = new Topping("Marshmallow", 0.70);
        Topping oreo = new Topping("Crushed Oreo", 0.85);
        Topping strawberries = new Topping("Fresh Strawberries", 1.00);
        Topping chocolateChips = new Topping("Chocolate Chips", 0.50);

        Order order = new Order();
        Scanner scanner = new Scanner(System.in);

        order.addFlavor(fudge, 1);
        order.addFlavor(mint, 1);
        order.addTopping(chocolateChips, 1);
        order.addTopping(strawberries, 2);
        order.setServingStyle(true);

        System.out.println("Subtotal: $" + order.calculateSubtotal());
        System.out.println("Tax: $" + order.calculateTax());
        System.out.println("Total: $" + order.calculateTotal());

        try {
            order.generateInvoice("invoice.txt");
            System.out.println("Invoice generated successfully.");
        } catch (Exception e) {
            System.out.println("Error generating invoice.");
        }
    }
}
