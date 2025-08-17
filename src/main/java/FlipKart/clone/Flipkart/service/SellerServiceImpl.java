package FlipKart.clone.Flipkart.service;

import FlipKart.clone.Flipkart.entity.Seller;
import FlipKart.clone.Flipkart.repository.SellerRepository;
import FlipKart.clone.Flipkart.uniqueIdGenerator.GSTNumberGenerator;
import FlipKart.clone.Flipkart.uniqueIdGenerator.PanNumberGenerator;
import FlipKart.clone.Flipkart.uniqueIdGenerator.SellerIdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public Seller saveSeller(Seller seller) {
        log.info("generating unique sallerId for the seller {}: ", seller.getName());
        seller.setSellerId(SellerIdGenerator.generateUniqueCustId());

        seller.setType("SELLER");

        log.info("generating unique GST number for the seller {}:", seller.getName());
        seller.setGSTNumber(GSTNumberGenerator.generateGSTId());

        log.info("generating unique Pan number for the seller {}:", seller.getName());
        seller.setPanNumber(PanNumberGenerator.generateUniquePanId());

        log.info("saving seller in DB name: {} ", seller.getName());
        Seller sellerSave = sellerRepository.save(seller);
        if (sellerSave == null) {
            throw new RuntimeException("Failed to save Seller: " + seller.getName());
        }
        return sellerSave;
    }

    @Transactional
    @Override
    public String deleteSeller(String sellerId) {
        log.info("checking is seller exist with the Id: {}", sellerId);
        if (isSellerExist(sellerId)) {
            sellerRepository.deleteBySellerId(sellerId);

            log.info("seller is successfully deleted with the ID {} ", sellerId);

            return "seller is succefully deleted ID: " + sellerId;
        }
        return "seller does not exist with the Id: " + sellerId;
    }

    public boolean isSellerExist(String sellerId) {

        return sellerRepository.existsBySellerId(sellerId);
    }

}
