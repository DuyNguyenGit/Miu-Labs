package lesson9.labs.prob11b;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class LambdaLibrary {
    public static final BiFunction<List<Employee>, Integer, String> EMPLOYEE_NAMES =
            (employees, minSalary) ->
                    employees.stream()
                            .filter(emp -> emp.getSalary() > minSalary)
                            .filter(emp -> emp.getLastName().matches("^[N-Z].*"))
                            .map(emp -> emp.getFirstName() + " " + emp.getLastName())
                            .sorted()
                            .collect(Collectors.joining(", "));
}
