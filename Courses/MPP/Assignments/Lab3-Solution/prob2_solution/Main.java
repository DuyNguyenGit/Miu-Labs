package lesson3.labs.prob2_solution;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LandlordInfo landlord = new LandlordInfo();
        landlord.addBuilding(150, 400);
        landlord.addBuilding(175, 900);
        landlord.addBuilding(150, 300);
        landlord.addBuilding(175, 775);

        List<Building> buildings = landlord.getBuildings();
        buildings.get(0).addApartment(600);
        buildings.get(0).addApartment(700);

        buildings.get(1).addApartment(500);
        buildings.get(1).addApartment(450);

        buildings.get(2).addApartment(1100);
        buildings.get(2).addApartment(650);

        buildings.get(3).addApartment(400);
        buildings.get(3).addApartment(900);

        System.out.println(landlord.calcProfits());
    }
}
