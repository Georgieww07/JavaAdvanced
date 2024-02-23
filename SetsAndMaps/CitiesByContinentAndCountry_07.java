package SetsAndMaps;

import java.util.*;

public class CitiesByContinentAndCountry_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, List<String>>> data = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] inputParts = scanner.nextLine().split("\\s+");
            String continent = inputParts[0];
            String country = inputParts[1];
            String city = inputParts[2];

            data.putIfAbsent(continent, new LinkedHashMap<>());
            data.get(continent).putIfAbsent(country, new ArrayList<>());
            data.get(continent).get(country).add(city);


        }
        //Europe:
        //  Bulgaria -> Sofia, Plovdiv
        //  Poland -> Warsaw, Poznan
        //  Germany -> Berlin
        //Asia:
        //  China -> Beijing, Shanghai
        //  Japan -> Tokyo
        //Africa:
        //  Nigeria -> Abuja


        for (Map.Entry<String, Map<String, List<String>>> entry : data.entrySet()) {
            String entryContinent = entry.getKey();

            System.out.printf("%s:%n", entryContinent);

            entry.getValue().forEach((key, value) -> System.out.printf("  %s -> %s\n", key, String.join(", ", value)));

        }
    }
}
