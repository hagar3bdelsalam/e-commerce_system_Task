import java.util.List;
import java.util.ArrayList;
import java.util.AbstractMap;
public class Checkout {
    private Cart cart;
    private Customer customer;
    private double subTotal;
    private double shippingFees;

    public Checkout(Cart cart, Customer customer) {
        this.cart = cart;
        this.customer = customer;
    }

    public void calculateTotalPrice() {
        subTotal = 0;
        for (CartItems item : cart.getItems()) {
            subTotal += item.getProduct().getPrice() * item.getQuantity();
        }
    }

    public void completePurchase() {
        ShippingService shippingService = new ShippingService();
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty. Cannot complete purchase.");
        }
        calculateTotalPrice();
        // Shippable + Quantity
        List<AbstractMap.SimpleEntry<Shippable, Integer>> shippables = new ArrayList<>();
        for (CartItems item : cart.getItems()) {
            Product product = item.getProduct();
            if (product.isShippable()) {
                shippables.add(new AbstractMap.SimpleEntry<>((Shippable) product, item.getQuantity()));
            }
        }
        shippingFees = shippingService.calculateShippingFees(shippables);
        double totalPrice = subTotal + shippingFees;
        if (customer.getBalance() < totalPrice) {
            throw new IllegalStateException("Insufficient balance to complete the purchase.");
        }
        customer.setBalance(customer.getBalance() - totalPrice);
        shippingService.printShipmentNotice(shippables);
        printReceipt();
        cart.clear(); // Clear the cart after purchase
    }


    private void printReceipt() {
        System.out.println("** checkout receipt **");
        for (CartItems item : cart.getItems()) {
            System.out.println(item.getQuantity()+ "x " + item.getProduct().getName() + "  " + 
                               (item.getProduct().getPrice() * item.getQuantity()));
        }
        System.out.println("----------------------");
        System.out.println("Subtotal " + subTotal);
        System.out.println("Shipping " + shippingFees);
        double totalPrice = subTotal + shippingFees;
        System.out.println("Amount " + totalPrice);
    }

}