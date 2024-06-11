package prob4E;

import java.util.List;

public class Admin {
    public static double computeUpdatedBalanceSum(List<Employee> list) {
        //implement
        double sum = 0;
        for (Employee employee : list) {
            sum += employee.computeUpdatedBalanceSum();
        }
        return sum;
    }
}
