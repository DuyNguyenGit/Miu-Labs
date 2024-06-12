package lession9.excercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Lession9 {
    public static final void main(String[] args) {
        public static void main(String[] args) {
            List<Account> accounts = new ArrayList<Account>() {
                {
                    add(new Account("Bob", 5000, 1001));
                    add(new Account("Jim", 10000, 1002));
                    add(new Account("Bruce", 5300, 1003));
                    add(new Account("Li", 12000, 1004));
                    add(new Account("Sam", 9000, 1005));
                    add(new Account("Rick", 11000, 1006));
                }
            };

            //sorting code here
            Function<Account, Integer> byBalance = Account::getBalance;
            Function<Account, String> byOwnerName = Account::getOwnerName;

            Collections.sort(accounts, Comparator.comparing(byBalance).thenComparing(byOwnerName));
            System.out.println(accounts);
        }
    }
}
