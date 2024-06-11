package prob4E;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	private String name;
	private List<Account> accountList;

	public Employee(String name) {
		this.name = name;
		this.accountList = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void addAccount(Account account) {
		this.accountList.add(account);
	}

	public double computeUpdatedBalanceSum() {
		//implement
		double sum = 0;
		for (Account account : accountList) {
			sum += account.computeUpdatedBalance();
		}
		return sum;
	}
}
