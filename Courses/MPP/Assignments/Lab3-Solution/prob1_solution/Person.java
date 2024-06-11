package lesson3.labs.prob1_solution;


public class Person {

	private String name;
	Person(String n) {
		name = n;
	}
	public String getName() {
		return name;
	}
	@Override
	public boolean equals(Object aPerson) {
		if(aPerson == null) return false;
		if(!(aPerson instanceof lesson3.labs.prob1.Person)) return false;
		lesson3.labs.prob1.Person p = (lesson3.labs.prob1.Person)aPerson;
		boolean isEqual = this.name.equals(p.getName());
		return isEqual;
	}
	public static void main(String[] args) {
		
	}

}
