package lesson3.labs.prob3_solution;


public class House extends Property {

    private double lotSize;
    private Address address;
    public Address getAddress() {
        return address;
    }
    public House(Address address, double lotSize) {
        this.address = address;
        this.lotSize = lotSize;
    }

    @Override
    protected double computeRent() {
        return lotSize * 0.1;
    }
}
