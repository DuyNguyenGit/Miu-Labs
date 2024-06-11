package lesson3.labs.prob3_solution;

public class Trailer extends Property {
    private static final double RENT = 500;
    private Address address;

    public Address getAddress() {
        return address;
    }

    public Trailer(Address address) {
        this.address = address;
    }

    @Override
    protected double computeRent() {
        return RENT;
    }
}
