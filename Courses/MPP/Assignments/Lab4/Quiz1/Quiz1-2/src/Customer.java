public class Customer {
    private String name;
    private Account account;

    public Customer(String name, String accountId) {
        this.name = name;
        this.account = new Account(accountId, this);
    }
}
