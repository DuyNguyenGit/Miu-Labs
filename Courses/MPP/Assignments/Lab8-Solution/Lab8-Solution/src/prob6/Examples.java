package prob6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Examples {

    // (Employee e) -> e.getName()
    // type: Class::instanceMethod
    Function<Employee, String> getName1 = (Employee e) -> e.getName();
    Function<Employee, String> getName2 = Employee::getName;

    // (Employee e,String s) -> e.setName(s)
    // type: Class::instanceMethod
    BiConsumer<Employee, String> setName1 = (Employee e, String s) -> e.setName(s);
    BiConsumer<Employee, String> setName2 = Employee::setName;

    // (String s1,String s2) -> s1.compareTo(s2)
    // type: Class::instanceMethod
    Comparator<String> comp1 = (String s1, String s2) -> s1.compareTo(s2);
    Comparator<String> comp2 = String::compareTo;

    // (Integer x,Integer y) -> Math.pow(x,y)
    // type: Class::staticMethod
    BiFunction<Integer, Integer, Double> pow1 = (Integer x, Integer y) -> Math.pow(x, y);
    BiFunction<Integer, Integer, Double> pow2 = Math::pow;

    // (String x) -> Integer.parseInt(x)
    // type: Class::staticMethod
    Function<String, Integer> parse1 = (String x) -> Integer.parseInt(x);
    Function<String, Integer> parse2 = Integer::parseInt;

    // (Employee e1, Employee e2) -> comp.compare(e1,e2)
    // type: object::instanceMethod
    EmployeeNameComparator comp = new EmployeeNameComparator();
    Comparator<Employee> compare1 = (Employee e1, Employee e2) -> comp.compare(e1, e2);
    Comparator<Employee> compare2 = comp::compare;


    public void evaluator() {
        Employee employee = new Employee("Duy", 100000);
        System.out.println(getName2.apply(employee));

        setName2.accept(employee, "Van Duy");
        System.out.println(getName2.apply(employee));

        System.out.println(comp2.compare("Duy", "Dyu"));

        System.out.println(pow2.apply(2, 3));

        System.out.println(parse2.apply("10"));

		Employee employee2 = new Employee("Van Duy", 50000);
        System.out.println(compare2.compare(employee, employee2));
    }

    public static void main(String[] args) {
        Examples e = new Examples();
        e.evaluator();
//        Stream.iterate(1, n -> n + 2)
//                .skip(5)
//                .limit(4)
//                .collect(Collectors.toList())
//                .forEach(i -> System.out.println(i));
    }
}
