package cities;

import java.util.List;
import java.util.ArrayList;

public class Country implements Comparable<Country> {
    private java.util.Set<City> cities = new java.util.HashSet<>();
    private String name;

    public Country(String name) {
        this.name = name;
    }

    public void addCity(City city) {
        if (!city.getCountry().equals(this)) {
            throw new IllegalArgumentException("City does not belong to this country");
        }
        cities.add(city);
    }

    public int population() {
        int finalPopulation = 0;

        for (City c : cities) {
            finalPopulation += c.getPopulation();
        }
        return finalPopulation;
    }

    @Override
    public String toString() {
        return name;
    }
    
    public List<City> smallCities(int under) {
        List<City> smallCities = new ArrayList<>();

        for (City c : cities) {
            if (c.getPopulation() < under) {
                smallCities.add(c);
            }
        }

        smallCities.sort(java.util.Comparator.comparingInt(City::getPopulation).reversed());
        return smallCities;
    }

    public String report() {
        String report = this.name + "(" + population() + ") : ";

        List<City> sortedCities = new ArrayList<>(cities);
        sortedCities.sort(java.util.Comparator.comparingInt(City::getPopulation).reversed());

        for (int i = 0; i < sortedCities.size(); i++) {
            City c = sortedCities.get(i);
            report += c.getName() + "(" + c.getPopulation() + ")";
            if (i < sortedCities.size() - 1)
                report += ", ";
        }
        return report;
    }

    @Override
    public int compareTo(Country other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Country)) return false;
        return this.name.equals(((Country) obj).name);
    }
}
