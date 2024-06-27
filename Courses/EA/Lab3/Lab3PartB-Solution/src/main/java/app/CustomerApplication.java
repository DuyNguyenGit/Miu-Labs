package app;

import java.util.List;
import java.util.Optional;

import app.domain.Book;
import app.domain.Customer;
import app.repositories.BookRepository;
import app.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
public class CustomerApplication implements CommandLineRunner{
	
	@Autowired
	CustomerRepository customerrepository;
	@Autowired
	BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerrepository.save(new Customer("Jack", "Bauer", "jack@acme.com"));
		customerrepository.save(new Customer("Chloe", "O'Brian", "chloe@acme.com"));
		customerrepository.save(new Customer("Kim", "Bauer", "kim@acme.com"));
		customerrepository.save(new Customer("David", "Palmer", "dpalmer@gmail.com"));
		customerrepository.save(new Customer("Michelle", "Dessler", "mich@hotmail.com"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : customerrepository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer by ID
		Optional<Customer> custOpt = customerrepository.findById(1L);
		Customer customer = custOpt.get();
		System.out.println("Customer found with findOne(1L):");
		System.out.println("--------------------------------");
		System.out.println(customer);
		System.out.println();

		// Book
		bookRepository.save(new Book(1, "Java Tutorial", "1234", "Meyssa", 100000d));
		bookRepository.save(new Book(2, "SpringBoot Tutorial", "12345", "Duy", 50000d));
		bookRepository.save(new Book(3, "Android Tutorial", "123456", "Meyssa", 10000d));

		// fetch all books
		fetAllBook();

		System.out.println("-------------------------------");

		// update Book
		updateBook();

		// Delete a book (not a book just updated)
		deleteBook();
	}

	private void deleteBook() {
		System.out.println("Delete book with book ID = 2:");
		System.out.println("----");
		Book deleteBook = new Book(2,"SpringBoot Tutorial", "12345", "Duy", 50000d);
		bookRepository.delete(deleteBook);
		System.out.println("All books after updated");
		fetAllBook();
	}

	private void updateBook() {
		System.out.println("Update book with book ID = 1: Change the Book price from 100000 to 22220");
		System.out.println("----");
		Book newBook = new Book(1, "Java Tutorial", "1234", "Meyssa", 22220);
		bookRepository.save(newBook);
		System.out.println("All books after updated");
		fetAllBook();
	}

	private void fetAllBook() {
		System.out.println("Books found with findAll():");
		System.out.println("-------------------------------");
		for (Book book : bookRepository.findAll()) {
			System.out.println(book);
		}
		System.out.println();
	}
}
