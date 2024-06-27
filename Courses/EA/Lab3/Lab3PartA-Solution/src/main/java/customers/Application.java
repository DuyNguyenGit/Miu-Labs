package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerDAO customerDao;
	@Autowired
	private ProductDAO productDAO;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerDao.clearDB();
		Customer customer = new Customer(101,"John doe", "johnd@acme.com", "0622341678");
		CreditCard creditCard = new CreditCard("12324564321", "Visa", "11/23");
		customer.setCreditCard(creditCard);
		customerDao.save(customer);
		customer = new Customer(66,"James Johnson", "jj123@acme.com", "068633452");
		creditCard = new CreditCard("99876549876", "MasterCard", "01/24");
		customer.setCreditCard(creditCard);
		customerDao.save(customer);
		System.out.println(customerDao.getCustomer(101));
		System.out.println(customerDao.getCustomer(66));
		System.out.println("-----------All customers ----------------");
		System.out.println(customerDao.getAllCustomers());

		productDAO.clearDB();
		Product product1 = new Product("1001", "Iphone 15", 123456.0);
		Supplier supplier1 = new Supplier("Apple", "0999999999");
		product1.setSupplier(supplier1);
		Product product2 = new Product("1002", "Iphone 14", 110456.0);
		Supplier supplier2 = new Supplier("Apple", "0888888888");
		product2.setSupplier(supplier2);
		productDAO.save(product1);
		productDAO.save(product2);

		System.out.println("-----------Query for Product ----------------");
		System.out.println(productDAO.findByProductNumber("1001"));
		System.out.println(productDAO.findByProductName("Iphone 14"));
		System.out.println("-----------All products ----------------");
		System.out.println(productDAO.getAllProducts());
		productDAO.removeProduct("1001");
		System.out.println("-----------All products ----------------");
		System.out.println(productDAO.getAllProducts());
	}
}
