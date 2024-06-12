import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("John Doe", 20000.00));
        employees.add(new Employee("John Doe", 2000.00));
        employees.add(new Employee("Jane Doe", 20000.00));
        employees.add(new Employee("Jane Doe", 20000.00));

        System.out.println("The list of employees:");
        System.out.println(employees);

        HashMap<Employee, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee, employee);
        }

        System.out.println("The list after remove redundant employees:");
        map.forEach((key, val) -> System.out.println(val));

    }
}