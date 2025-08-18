package FlipKart.clone.Flipkart.repository;

import FlipKart.clone.Flipkart.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseBody;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    void deleteByCustomerId(String customerId);

    boolean existsByCustomerId(String customerId);
}
