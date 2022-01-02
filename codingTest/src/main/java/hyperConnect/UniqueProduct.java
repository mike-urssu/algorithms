package hyperConnect;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a method that, efficiently with respect to time used, the first product in an array that occurs only once in that array.
 * If there are no unique products in the array, null should be returned.
 *
 * For example, firstUniqueProduct(new String[] {"Apple", "Computer", "Apple", "Bag"}) should return "Computer".
 */

public class UniqueProduct {
    public static String firstUniqueProduct(String[] products) {
        /*
         * given
         * throw new UnsupportedOperationException("waiting to be implemented");
         */

        // answer
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