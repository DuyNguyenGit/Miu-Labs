package prob2.a;

import java.util.Comparator;

/* A functor, but not a closure */
public class EmployeeNameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        int nameComparation = e1.name.compareTo(e2.name);
        if (nameComparation == 0) {
            if (e1.salary == e2.salary) return 0;
            else if (e1.salary < e2.salary) return -1;
            else return 1;
        }
        return nameComparation;
    }
}
