package lesson3.labs.prob2_solution;

import java.util.ArrayList;
import java.util.List;

public class LandlordInfo {
    private List<Building> buildings;

    public List<Building> getBuildings() {
        return buildings;
    }

    public LandlordInfo() {
        buildings = new ArrayList<>();
    }

    public void addBuilding(int maintainanceCost, int firstApartmentRent) {
        Building b = new Building(maintainanceCost, firstApartmentRent);
        buildings.add(b);
    }

    public int calcProfits() {
        return this.helperMethod();

    }

    private int helperMethod() {
        int profit = 0;
        for(Building building : buildings) {
            profit = profit + building.calcProfits();
        }
        return profit;
    }

}
