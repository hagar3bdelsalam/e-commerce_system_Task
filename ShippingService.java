import java.util.AbstractMap;
import java.util.List;
public class ShippingService {

    public double calculateShippingFees(List<AbstractMap.SimpleEntry<Shippable, Integer>> shippables) {
        double totalWeight = 0;
        for (AbstractMap.SimpleEntry<Shippable, Integer> entry : shippables) {
            Shippable item = entry.getKey();
            int quantity = entry.getValue();
            totalWeight += item.getWeight() * quantity;
        }

        return totalWeight * 5;  // Assuming a shipping fee of $5 per kg
    }

    public void printShipmentNotice(List<AbstractMap.SimpleEntry<Shippable, Integer>> shippables) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        for (AbstractMap.SimpleEntry<Shippable, Integer> entry : shippables) {
            Shippable item = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(quantity + "x " + item.getName() + " " + (item.getWeight() * 1000) + "g");
            totalWeight += item.getWeight() * quantity;
        }
        System.out.println("Total package weight " + totalWeight + "kg");
    }
}