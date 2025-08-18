package FlipKart.clone.Flipkart.controller;

import FlipKart.clone.Flipkart.entity.Seller;
import FlipKart.clone.Flipkart.service.SellerService;
import jakarta.validation.Valid;
import lombok.Generated;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Controller
@Slf4j
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @ResponseBody
    @PostMapping("/saveSeller")
    public ResponseEntity<Map<String, Object>> saveSeller(@Valid @RequestBody Seller seller) {
        log.info("seller Controllr: {}", seller);

        Seller saveSeller = sellerService.saveSeller(seller);

        Map<String, Object> response = new HashMap<>();

        response.put("message", " Seller saved successfully!");
        response.put("data", saveSeller);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteSellerById/{sellerId}")
    @ResponseBody
    public ResponseEntity<String> deleteSeller(@PathVariable String sellerId) {
        log.info("Seller Controller: deleting seller for ID: {} ", sellerId);
        return new ResponseEntity<>("message: " + sellerService.deleteSeller(sellerId), HttpStatus.GONE);

    }
}
