import java.util.Date;
public class Main {
    public static void main(String[] args) {
        Product cheese = new ExpirableProducts("Cheese", 5.0, 10, 1.0, new Date(System.currentTimeMillis() + 100000));
        Product biscuits = new ExpirableProducts("Biscuits", 2.0, 20, 0.5, new Date(System.currentTimeMillis() + 200000));
        Product tv = new NotExpirableProducts("TV", 300.0, 5, 10.0);
        Product scratchCard = new OtherProducts("Scratch Card", 10.0, 100);

        System.out.println("Successful Operation");
        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 3);
        cart.add(tv, 1);
        cart.add(scratchCard, 5);
        Customer customer = new Customer("John Doe", 1000.0);
        Checkout checkout = new Checkout(cart, customer);
        try {
            checkout.completePurchase();
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage()); 
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }

        // Test empty cart operation
        System.out.println("Empty Cart Operation");
        Cart emptyCart = new Cart();
        try {
            Checkout emptyCheckout = new Checkout(emptyCart, customer);
            emptyCheckout.completePurchase();
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());      
        }

        // Test insufficient balance operation
        System.out.println("Insufficient Balance Operation");
        Cart insufficientBalanceCart = new Cart();
        try {
            insufficientBalanceCart.add(tv, 3);
            Checkout insufficientBalanceCheckout = new Checkout(insufficientBalanceCart, customer);
            insufficientBalanceCheckout.completePurchase();
        } catch (IllegalStateException e) {    
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }

        // Test expired product operation
        System.out.println("Expired Product Operation");
        Cart expiredProductCart = new Cart();
        Product expiredCheese = new ExpirableProducts("Expired Cheese", 5.0, 10, 1.0, new Date(System.currentTimeMillis() - 100000));
        try {
            expiredProductCart.add(expiredCheese, 2);
            Checkout expiredProductCheckout = new Checkout(expiredProductCart, customer);
            expiredProductCheckout.completePurchase();
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }

        // Test out of stock operation
        System.out.println("Out of Stock Operation");
        Cart outOfStockCart = new Cart();
        Product outOfStockProduct = new NotExpirableProducts("Out of Stock TV", 300.0, 1, 10.0);
        try {
            outOfStockCart.add(outOfStockProduct, 2);
            Checkout outOfStockCheckout = new Checkout(outOfStockCart, customer);
            outOfStockCheckout.completePurchase();
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) { 
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
