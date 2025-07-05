import java.util.*;

public class Cart {
    private List<CartItems> items = new ArrayList<>();

    public void add(Product product, int quantity) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if (product.getQuantity() < quantity) {
            throw new IllegalArgumentException("Not enough stock available for " + product.getName());
        }
        if (product.isExpired()) {
            throw new IllegalArgumentException("Product " + product.getName() + " is expired and cannot be added to the cart");
        }
        product.reduceQuantity(quantity);
        // check if product is already in the cart
        for (CartItems item : items) {
            if (item.getProduct().getName().equals(product.getName())) {
                // if product is already in the cart, increase the quantity
                item.getProduct().setQuantity(item.getProduct().getQuantity() + quantity);
                return;
            }
        }
        CartItems item = new CartItems(product, quantity);
        items.add(item);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public List<CartItems> getItems() {
        return items;
    }
    public void clear() {
        items.clear();
    }
}
