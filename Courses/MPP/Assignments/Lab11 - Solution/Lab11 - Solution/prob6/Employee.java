package lesson11.labs.prob6;

public class Employee extends Person {
	int id;
	int salary;
	
	public Employee(int id, String n, int s) {
		super(n);
		this.id = id;
		this.salary = s;
		
	}
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("<");
		sb.append("name: ");
		sb.append(getName());
		sb.append(" salary: ");
		sb.append("" + salary);
		sb.append(" year of birth: ");
		return sb.toString();
		
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(!(obj instanceof Employee)) {
			return false;
		}
		Employee e = (Employee) obj;
		return this.id == e.id && this.salary == e.salary && this.name.equals(e.name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}


}

