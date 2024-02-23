package SetsAndMaps;

import java.util.*;

public class ProductShop_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> shopsInfo = new TreeMap<>();

        while (true) {
            String input = scanner.nextLine();
            if ("Revision".equals(input)) {
                break;
            }

            String[] inputParts = input.split(",\\s+");
            String shop = inputParts[0];
            String product = inputParts[1];
            double price = Double.parseDouble(inputParts[2]);

            shopsInfo.putIfAbsent(shop, new LinkedHashMap<>());
            shopsInfo.get(shop).put(product, price);
        }

        for (Map.Entry<String, Map<String, Double>> entry : shopsInfo.entrySet()) {
            System.out.printf("%s->%n", entry.getKey());
            //Product: apple, Price: 1.2

            entry.getValue().forEach((key, value) -> System.out.printf("Product: %s, Price: %.1f%n", key, value));

        }

    }
}

