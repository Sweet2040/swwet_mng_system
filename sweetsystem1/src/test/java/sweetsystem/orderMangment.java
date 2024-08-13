package sweetsystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class orderMangment {
	private OrderManagementService orderManagementService = new OrderManagementService();

    private OrderService orderService; // Assuming an OrderService class handles order operations
    private String currentOrderId;
    private String currentOrderStatus;

    public orderMangment() {
        // Initialize OrderService or use a mock
        this.orderService = new OrderService(); // Replace with actual implementation or mock
    }

    @Given("I am on the order management page")
    public void iAmOnTheOrderManagementPage() {
        // Code to navigate to the order management page
        // For example, you might set up a mock or ensure the service is in the correct state
        System.out.println("Navigated to order management page.");
    }

    @When("I create a new order with details {string}")
    public void iCreateANewOrderWithDetails(String details) {
        orderManagementService.createOrder("ORDER1", details);
        Order order = orderManagementService.getOrderById("ORDER1");
        assertNotNull("Order was not created and stored properly", order); // Additional check
    }

    @Then("the order should be processed successfully")
    public void theOrderShouldBeProcessedSuccessfully() {
        Order order = orderManagementService.getOrderById("ORDER1");
        assertNotNull("Order should not be null", order);
        assertEquals("The order was not processed successfully.", "Processed", order.getStatus());
    }

    

    @Given("I have created an order with details {string}")
    public void iHaveCreatedAnOrderWithDetails(String details) {
        // Code to create an order with the given details and store its ID
        currentOrderId = orderService.createOrder(details);
        System.out.println("Created order with ID: " + currentOrderId);
    }

    @When("I update the status of the order to {string}")
    public void iUpdateTheStatusOfTheOrderTo(String status) {
        // Code to update the status of the current order
        orderService.updateOrderStatus(currentOrderId, status);
        currentOrderStatus = status;
        System.out.println("Updated order ID " + currentOrderId + " to status: " + status);
    }

    @Then("the order status should be {string}")
    public void theOrderStatusShouldBe(String expectedStatus) {
        // Code to verify that the order status matches the expected status
        String actualStatus = orderService.getOrderStatus(currentOrderId);
        if (!expectedStatus.equals(actualStatus)) {
            throw new AssertionError("Expected status: " + expectedStatus + ", but got: " + actualStatus + ". Order ID: " + currentOrderId);
        }
        System.out.println("Order status is as expected: " + expectedStatus);
    }
}

class OrderService {
    // Mock implementation for demonstration purposes
    private Map<String, String> orders = new HashMap<>();
    private static int orderCounter = 1;

    public String createOrder(String details) {
        String orderId = "ORDER" + (orderCounter++);
        orders.put(orderId, "Created;Details: " + details);
        return orderId;
    }

    public void updateOrderStatus(String orderId, String status) {
        if (orders.containsKey(orderId)) {
            String currentDetails = orders.get(orderId);
            orders.put(orderId, status + ";" + currentDetails.split(";")[1]);
        } else {
            throw new IllegalArgumentException("Order ID not found: " + orderId);
        }
    }

    public boolean isOrderProcessed(String orderId) {
        return orders.containsKey(orderId) && orders.get(orderId).startsWith("Shipped");
    }

    public String getOrderStatus(String orderId) {
        return orders.getOrDefault(orderId, "Order not found").split(";")[0];
    }
}


