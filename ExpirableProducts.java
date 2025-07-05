import java.util.Date;
public class ExpirableProducts extends Product implements Expirable, Shippable {
    private double weight;
    private Date expirationDate;

    public ExpirableProducts(String name, double price, int quantity, double weight, Date expirationDate) {
        super(name, price, quantity);
        this.weight = weight;
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean isExpired() {
        return expirationDate.before(new Date());    // Logic to check if the product is expired based on the current date and expirationDate
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public Date getExpirationDate() {
        return expirationDate;  
    }

    @Override
    public boolean isShippable() {
        return true; // Assuming all expirable products are shippable
    }

}
