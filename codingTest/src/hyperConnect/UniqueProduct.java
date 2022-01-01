package hyperConnect;

import java.util.HashMap;
import java.util.Map;

public class UniqueProduct {
    public static String firstUniqueProduct(String[] products) {
        Map<String, Integer> inventory = new HashMap<>();
        for (String product : products)
            inventory.put(product, inventory.getOrDefault(product, 0) + 1);

        for (String product : products) {
            if (inventory.get(product) == 1)
                return product;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqueProduct(new String[]{"Apple", "Computer", "Apple", "Bag"}));
    }
}