import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Commissioned extends Employee {

    private double commission;
    private double baseSalary;
    private List<Order> orderList;

    public Commissioned(String empId, double commission, double baseSalary) {
        super(empId);
        this.orderList = new ArrayList<>();
        this.commission = commission;
        this.baseSalary = baseSalary;
    }


    public Paycheck calcCompensation(int month, int year) {
        double grossPay = calcGrossPay(month, year);
        double fica = 23 * grossPay / 100;
        double state = 5 * grossPay / 100;
        double localTax = 1 * grossPay / 100;
        double medicare = 3 * grossPay / 100;
        double socialSecurity = 7.5 * grossPay / 100;

        return new Paycheck(grossPay, fica, state, localTax, medicare, socialSecurity);
    }

    @Override
    public double calcGrossPay(int month, int year) {
        double orderSum = 0;
        for (Order order : orderList) {
            orderSum += order.getOrderAmount();
        }
        return baseSalary + orderSum * commission;
    }

    public void addNewOrder(int orderNumber, LocalDate date, double orderAmount) {
        orderList.add(new Order(orderNumber, date, orderAmount));
    }
}
