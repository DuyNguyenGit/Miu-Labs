package prob4E;

public class SavingsAccount extends Account {

    private String accId;
    private double balance;
    private double interestRate;

    public SavingsAccount(String accId, double balance, double interestRate) {
        this.accId = accId;
        this.balance = balance;
        this.interestRate = interestRate;
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
        return this.balance + this.interestRate*this.balance;
    }
}
