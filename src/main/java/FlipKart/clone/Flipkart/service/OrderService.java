package FlipKart.clone.Flipkart.service;

import FlipKart.clone.Flipkart.entity.Order;

public interface OrderService {

    public Order saveOrder(Order order);

    public Order fetchOrderById(int orderId);

}
