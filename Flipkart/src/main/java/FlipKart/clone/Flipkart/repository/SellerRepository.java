package FlipKart.clone.Flipkart.repository;

import FlipKart.clone.Flipkart.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {

    void deleteBySellerId(String customerId);

    boolean existsBySellerId(String customerId);

}
