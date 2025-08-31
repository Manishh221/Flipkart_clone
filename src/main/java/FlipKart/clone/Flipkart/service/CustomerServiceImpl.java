package FlipKart.clone.Flipkart.service;

import FlipKart.clone.Flipkart.entity.Customer;
import FlipKart.clone.Flipkart.enums.UserType;
import FlipKart.clone.Flipkart.repository.CustomerRepository;
import FlipKart.clone.Flipkart.uniqueIdGenerator.CartIdGenerator;
import FlipKart.clone.Flipkart.uniqueIdGenerator.CustomerIdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) {

        log.info("Service class: method name saveUser: new user is being saved with the name: {}", customer.getName());

        customer.setUserType(UserType.CUSTOMER);

        log.info("Generating unique ID for the customer {}", customer);
        customer.setCustomerId(CustomerIdGenerator.generateUniqueCustId());

        log.info("generating cart id for the customer Id: {}", customer.getCustomerId());
        customer.setCustomerCartId(CartIdGenerator.generateUniqueCustId());

        customer = customerRepository.save(customer);

        log.info("User is successfully saved in DB {}", customer);
        return customer;
    }

    @Override
    @Transactional
    public String deleteCustomerById(@RequestParam String customerId) {

        log.info("customer is being deleted whose id is: {}", customerId);

        customerRepository.deleteByCustomerId(customerId);
        log.info("customer is deleted with id: {} ", customerId);
        return customerId;
    }

    public boolean isCustomerExists(String customerId) {

        log.info("service class: checking in DB is customer exist");

        return customerRepository.existsByCustomerId(customerId);
    }

    public Customer findCustomerById(String customerId){
        return customerRepository.findCustomerById(customerId);
    }
}
