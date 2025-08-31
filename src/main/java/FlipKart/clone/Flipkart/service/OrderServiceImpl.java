package FlipKart.clone.Flipkart.service;

import FlipKart.clone.Flipkart.entity.Order;
import FlipKart.clone.Flipkart.repository.OrderRepository;
import FlipKart.clone.Flipkart.uniqueIdGenerator.OrderIdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order saveOrder(Order order) {

        log.info("generating orderId for the placed order for the: {} ", order.getCustomerDetails().getCustomerName());
        order.setOrderId(OrderIdGenerator.generateUniqueCustId());
        log.info("orderService: order is being saved {} ", order.getOrderId());
        return orderRepository.save(order);
    }

    @Override
    public Order fetchOrderById(int orderId) {
        log.info("finding order by orderId:  {}", orderId );
         Order order = orderRepository.findById(orderId);
        return order;
    }
}
