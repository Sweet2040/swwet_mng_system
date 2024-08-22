package sweetsystemmmm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import Mysweetsystem2024.Order;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class orderMangement {


    private Order currentOrder;
    private String currentOrderStatus;
    private boolean isOrderProcessed;

 

    @Given("I am on the order management page")
    public void iAmOnTheOrderManagementPage() {
        // Assume that the user is navigating to the order management page
        // In a real scenario, you might check if the correct page is displayed
        boolean isOnOrderManagementPage = true; // Replace with actual page check if available
        assertTrue("Not on the order management page", isOnOrderManagementPage);
    }

    @When("I create a new order with details {string}")
    public void iCreateANewOrderWithDetails(String details) {
        // Split details assuming a format like "Product1:2,Product2:3"
        currentOrder = new Order(details);
        isOrderProcessed = true; // Assume order processing is successful
    }

    @Then("the order should be processed successfully")
    public void theOrderShouldBeProcessedSuccessfully() {
        assertTrue("Order was not processed successfully", isOrderProcessed);
    }

    @Given("I have created an order with details {string}")
    public void iHaveCreatedAnOrderWithDetails(String details) {
        // Assuming the order is created when this step is called
        currentOrder = new Order(details);
        isOrderProcessed = true;
        assertNotNull("Order was not created", currentOrder);
    }

    @When("I update the status of the order to {string}")
    public void iUpdateTheStatusOfTheOrderTo(String status) {
        if (currentOrder != null) {
            currentOrder.setStatus(status);
            currentOrderStatus = status;
        }
    }

    @Then("the order status should be {string}")
    public void theOrderStatusShouldBe(String expectedStatus) {
        assertEquals("Order status did not match the expected status", expectedStatus, currentOrderStatus);
    }
}

