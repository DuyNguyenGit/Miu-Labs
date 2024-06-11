public class Salaried extends Employee {
    private double salary;

    public Salaried(String empId) {
        super(empId);
    }

    @Override
    public double calcGrossPay(int month, int year) {
        return salary;
    }
}
