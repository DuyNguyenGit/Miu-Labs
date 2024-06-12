import java.util.Objects;

public class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.salary);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj.getClass() != this.getClass())
            return false;
        Employee employee = (Employee) obj;
        return this.name.equals(employee.getName()) && this.salary == employee.salary;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", salary=" + salary + "]";
    }

}
