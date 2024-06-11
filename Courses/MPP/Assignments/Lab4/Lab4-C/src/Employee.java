abstract public class Employee {
    private String empId;

    public Employee(String empId) {
        this.empId = empId;
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

    public abstract double calcGrossPay(int month, int year);

}
