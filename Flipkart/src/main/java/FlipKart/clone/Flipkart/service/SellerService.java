package FlipKart.clone.Flipkart.service;

import FlipKart.clone.Flipkart.entity.Seller;

public interface SellerService {

    Seller saveSeller(Seller seller);

    String deleteSeller(String sellerId);

}
