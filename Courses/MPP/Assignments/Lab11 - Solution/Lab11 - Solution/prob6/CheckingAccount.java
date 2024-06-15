package lesson11.labs.prob6;

public class CheckingAccount extends Account {
	final double PENALTY = 10.00;
	public CheckingAccount(int id, double startBalance) {
		super(id, startBalance);
	}
	
	@Override
	public double getBalance() {
		return super.getBalance() - PENALTY;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if (!(obj instanceof CheckingAccount)) {
			return false;
		}
		CheckingAccount account = (CheckingAccount) obj;
		return this.getAcctId() == account.getAcctId() && this.getBalance() == account.getBalance();
	}
}
