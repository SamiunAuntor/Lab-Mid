import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IceCreamShopTest {
    @Test
    public void testSubtotal() {
        Order order = new Order();
        order.addFlavor(new Flavor("Chocolate Fudge", 3.00), 2);
        order.addTopping(new Topping("Sprinkles", 0.30), 1);
        order.setServingStyle(false);
        assertEquals(6.30, order.calculateSubtotal(), 0.01);
    }

    @Test
    public void testTotalPaperCup() {
        Order order = new Order();
        order.addFlavor(new Flavor("Strawberry Swirl", 2.75), 2);
        order.setServingStyle(false);
        assertEquals(5.94, order.calculateTotal(), 0.01);
    }

    @Test
    public void testInvoiceGeneration() throws Exception {
        Order order = new Order();
        order.addFlavor(new Flavor("Chocolate Fudge", 3.00), 1);
        order.addTopping(new Topping("Fresh Strawberries", 1.00), 2);
        order.setServingStyle(false);
        order.generateInvoice("test_invoice.txt");
    }
}
