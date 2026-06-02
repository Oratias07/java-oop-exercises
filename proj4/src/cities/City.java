package cities;

import java.util.Objects;

public class City implements Comparable<City> {
    // it is need to be private here?
    private String name;
    private Country country;
    private int population;

    public City(String name, Country country, int population) {
        this.name = name;
        this.country = country;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return name + " (of " + country + ")";
    }

    @Override
    public int compareTo(City other) {
        int countryComp = this.country.toString().compareTo(other.country.toString());
        if (countryComp != 0) return countryComp;
        return this.name.compareTo(other.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof City)) return false;
        City other = (City) obj;
        return this.name.equals(other.name) && this.country.equals(other.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country.toString());
    }
}
