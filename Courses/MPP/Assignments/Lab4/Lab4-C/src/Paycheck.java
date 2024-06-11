public class Paycheck {
    private double grossPay;
    private double fica;
    private double state;
    private double local;
    private double medicare;
    private double socialSecurity;

    public Paycheck(double grossPay, double fica, double state, double local, double medicare, double socialSecurity) {
        this.grossPay = grossPay;
        this.fica = fica;
        this.state = state;
        this.local = local;
        this.medicare = medicare;
        this.socialSecurity = socialSecurity;
    }

    @Override
    public String toString() {
        String paycheck = "PayCheck(" +
                "\n grossPay=" + this.grossPay +
                ",\n FICA=" + this.fica +
                ",\n State=" + this.state +
                ",\n localTax=" + this.local +
                ",\n medicare=" + this.medicare +
                ",\n socialSecurity=" + this.socialSecurity +
                ",\n netPay=" + this.getNetPay() + ")";
        return paycheck;
    }

    public double getNetPay() {
        return grossPay - (fica + state + local + medicare + socialSecurity);
    }

    public double getGrossPay() {
        return grossPay;
    }

    public double getFica() {
        return fica;
    }

    public double getState() {
        return state;
    }

    public double getLocal() {
        return local;
    }

    public double getMedicare() {
        return medicare;
    }

    public double getSocialSecurity() {
        return socialSecurity;
    }
}
