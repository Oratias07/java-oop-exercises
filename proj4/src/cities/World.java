package cities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class World {
    private Map<String, Country> countries = new HashMap<>();

    public void addCountry(String name) {
        countries.put(name, new Country(name));
    }

    public void addCity(String name, String countryName, int population) {
        Country c = countries.get(countryName);
        if (c == null) throw new IllegalArgumentException();
        City city = new City(name, c, population);
        c.addCity(city);
    }

    public int population() {
        int total = 0;
        for (Country c : countries.values()) {
            total += c.population();
        }
        return total;
    }

    public List<City> smallCities(int under) {
        List<City> result = new ArrayList<>();

        for (Country c : countries.values()) {
            result.addAll(c.smallCities(under));
        }
        Collections.sort(result);
        return result;
    }

    public String report() {
        List<Country> sortedCountries = new ArrayList<>(countries.values());
        Collections.sort(sortedCountries);

        StringBuilder report = new StringBuilder();
        for (Country c : sortedCountries) {
            report.append(c.report()).append("\n");
        }
        report.append("Total population is ").append(population()).append("\n");
        return report.toString();
    }
}
