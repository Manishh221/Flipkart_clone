package FlipKart.clone.Flipkart.service;


import FlipKart.clone.Flipkart.entity.Customer;

public interface CustomerService {

    Customer saveCustomer(Customer customer);

    String deleteCustomerById(String customerId);
}
