package FlipKart.clone.Flipkart.repository;

import FlipKart.clone.Flipkart.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    void deleteByCustomerId(String customerId);

    boolean existsByCustomerId(String customerId);
}
