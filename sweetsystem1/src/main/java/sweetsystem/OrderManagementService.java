package sweetsystem;

import java.util.HashMap;
import java.util.Map;

 public class OrderManagementService {
    private Map<String, Order> orders = new HashMap<>();

    // Method to create and process a new order
    public void createOrder(String orderId, String details) {
        Order order = new Order(orderId, details);
        order.setStatus("Processed");
        orders.put(orderId, order);
        System.out.println("Order stored with ID: " + orderId);
    }

    // Method to retrieve an order by ID
    public  Order getOrderById(String orderId) {
        return orders.get(orderId);
    }
  

    // Method to update the status of an existing order
    public void updateOrderStatus(String orderId, String status) {
        Order order = orders.get(orderId);
        if (order != null) {
            order.setStatus(status);
        }
    }
}

