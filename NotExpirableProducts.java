public class NotExpirableProducts extends Product implements Shippable {
    private double weight;

    public NotExpirableProducts(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
    @Override
    public boolean isShippable() {
        return true; // Assuming all non-expirable products are shippable
    }

}
