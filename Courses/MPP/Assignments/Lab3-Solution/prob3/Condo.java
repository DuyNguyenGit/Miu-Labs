package lesson3.labs.prob3;



public class Condo {
	private int numberOfFloors;
	private Address address;
	public Address getAddress() {
		return address;
	}
	public Condo(Address address, int numberOfFloors) {
		this.address = address;
		this.numberOfFloors = numberOfFloors;
	}

	public double computeRent(){
		return 500 * numberOfFloors;
	}
}
