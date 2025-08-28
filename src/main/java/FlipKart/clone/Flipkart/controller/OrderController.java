package FlipKart.clone.Flipkart.controller;

import FlipKart.clone.Flipkart.entity.Customer;
import FlipKart.clone.Flipkart.entity.Order;
import FlipKart.clone.Flipkart.entity.Seller;
import FlipKart.clone.Flipkart.service.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @PostMapping("/placeOrder")
       public ResponseEntity<Order> placeOrder(@RequestBody Order order) {

        log.info("order-Controller: order is getting placed for the customer: {}",
                                                                         order.getCustomerDetails());
        Order myOrder = orderService.saveOrder(order);

        return new ResponseEntity<>(myOrder, HttpStatus.CREATED);
}
}
