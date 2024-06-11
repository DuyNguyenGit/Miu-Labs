package lesson3.labs.prob3_solution;


public class Condo extends Property {
    private int numFloors;
    private Address address;

    public Address getAddress() {
        return address;
    }

    public Condo(Address address, int numFloors) {
        this.address = address;
        this.numFloors = numFloors;
    }

    @Override
    protected double computeRent() {
        return this.numFloors * 400;
    }
}
