package lesson3.labs.prob2_solution;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private int maintainanceCost;
    List<Apartment> apartments;

    public Building(int maintainanceCost, int firstApartmentRent) {
        this.maintainanceCost = maintainanceCost;
        this.apartments = new ArrayList<>();
        this.apartments.add(new Apartment(firstApartmentRent));
    }

    public void addApartment(int rent) {
        apartments.add(new Apartment(rent));
    }

    public int calcProfits() {
        int rentSum = 0;
        for (Apartment apartment : apartments) {
            rentSum = rentSum + apartment.getRent();
        }
        return rentSum - maintainanceCost;
    }
}
