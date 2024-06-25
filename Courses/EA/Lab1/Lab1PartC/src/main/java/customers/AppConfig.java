package customers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CustomerService customerService() {
        CustomerService customerService = new CustomerService();
        customerService.setCustomerDAO(customerDAO());
        customerService.setEmailSender(emailSender());
        return customerService;
    }

    @Bean
    public ICustomerDAO customerDAO() {
        return new CustomerDAO(logger());
    }

    @Bean
    public IEmailSender emailSender() {
        return new EmailSender(logger());
    }

    @Bean
    public ILogger logger() {
        return new Logger();
    }
}
