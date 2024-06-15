import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer(123, "John", "London"));
        customers.add(new Customer(456, "Jane", "Berlin"));
        customers.add(new Customer(789, "Bob", "Newyork"));
        customers.add(new Customer(456, "Mary", "Fairfield"));
        customers.add(new Customer(456, "Jack", "Fairfield"));

        System.out.println(findCustomer(customers, "Fairfield"));

    }

    private static List<String> findCustomer(List<Customer> customers, String city) {
        return customers
                .stream()
                .filter(cust -> cust.getCity().equals(city))
                .map(cust -> cust.getName())
                .toList();
    }
}