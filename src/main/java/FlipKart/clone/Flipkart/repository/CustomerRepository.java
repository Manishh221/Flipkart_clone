package FlipKart.clone.Flipkart.repository;

import FlipKart.clone.Flipkart.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    void deleteByCustomerId(String customerId);

    boolean existsByCustomerId(String customerId);

    @Query(value = "SELECT * FROM customer WHERE customer_id = :customerId", nativeQuery = true)
    Customer findCustomerById(@Param("customerId") String customerId);
}
