public class OtherProducts extends Product {

    public OtherProducts(String name, double price, int quantity) {
        super(name, price, quantity);
    }
    @Override
    public boolean isShippable() {
        return false; // Assuming all other products are not shippable
    }
}
