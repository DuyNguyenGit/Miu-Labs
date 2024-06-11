package prob4E;

public class CheckingAccount extends Account {
    private String accId;
    private double balance;
    private double monthlyFee;

    public CheckingAccount(String accId, double balance, double monthlyFee) {
        this.accId = accId;
        this.balance = balance;
        this.monthlyFee = monthlyFee;
    }

    @Override
    public String getAccountID() {
        return this.accId;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public double computeUpdatedBalance() {
        return this.balance - this.monthlyFee;
    }
}
