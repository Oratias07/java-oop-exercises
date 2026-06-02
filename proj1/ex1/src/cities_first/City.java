package cities_first;

public class City {
    private String name;
    private Road[] roads;
    private int numRoads; 

    public City(String name) {
        this.name = name;
        this.roads = new Road[10]; 
        this.numRoads = 0;
    }

    public void connect(Road r) {
        if (numRoads < roads.length) {
            roads[numRoads] = r;
            numRoads++;
        }
    }

    public City nearestCity() {
        if (numRoads == 0) {
            return null; 
        }
        Road nearestRoad = roads[0];
        for (int i = 1; i < numRoads; i++) {
            if (roads[i].getLength() < nearestRoad.getLength()) {
                nearestRoad = roads[i];
            }
        }
        return nearestRoad.getCity1() == this ? nearestRoad.getCity2() : nearestRoad.getCity1();
    }
    public String toString() {
        return this.name;
    }
}