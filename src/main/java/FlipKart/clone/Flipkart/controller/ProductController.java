package FlipKart.clone.Flipkart.controller;

import FlipKart.clone.Flipkart.entity.Product;
import FlipKart.clone.Flipkart.enums.MainCategory;
import FlipKart.clone.Flipkart.enums.SubCategory;
import FlipKart.clone.Flipkart.service.ProductService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @ResponseBody
    @PostMapping("/saveProduct")
    public ResponseEntity<Map<String, Object>> saveProduct(@Valid @RequestBody Product product) {

        log.info("class- Controller: is reached {}", product);
        Product saveProduct = productService.saveProduct(product);
        Map<String, Object> response = new HashMap<>();
        response.put("data", saveProduct);
        response.put("message", "Product is successfully saved");

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}

