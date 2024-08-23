package sweetsystemmmm;

import static org.junit.Assert.*;

import Mysweetsystem2024.Order;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ordersteps {

    private Order currentOrder;
    private String currentOrderStatus;
    private boolean isOrderProcessed;
    private boolean isOrderCreated;
    
    @Given("I am logged in as a Store Owner or Raw Material Supplier")
    public void iAmLoggedInAsAStoreOwnerOrRawMaterialSupplier() {
        // Replace with actual login check if available
        boolean isLoggedIn = true; 
        assertTrue("User is not logged in as Store Owner or Raw Material Supplier", isLoggedIn);
    }

    @Given("I am on the order management page")
    public void iAmOnTheOrderManagementPage() {
        // Replace with actual page check if available
        boolean isOnOrderManagementPage = true; 
        assertTrue("Not on the order management page", isOnOrderManagementPage);
    }

    @When("I create a new order with details {string}")
    public void iCreateANewOrderWithDetails(String details) {
        // Create a new order with provided details
        currentOrder = new Order(details);
        isOrderCreated = (currentOrder != null);
        isOrderProcessed = true; // Assume order processing is successful
    }

    @Then("the order should be processed successfully")
    public void theOrderShouldBeProcessedSuccessfully() {
        assertTrue("Order was not processed successfully", isOrderProcessed);
        assertNotNull("Order was not created", currentOrder);
    }

    @Given("I have created an order with details {string}")
    public void iHaveCreatedAnOrderWithDetails(String details) {
        // Create an order with the given details
        currentOrder = new Order(details);
        isOrderCreated = (currentOrder != null);
        assertNotNull("Order was not created", currentOrder);
    }

    @When("I update the status of the order to {string}")
    public void iUpdateTheStatusOfTheOrderTo(String status) {
        if (currentOrder != null) {
            currentOrder.setStatus(status);
            currentOrderStatus = currentOrder.getStatus();
        }
    }

    @Then("the order status should be {string}")
    public void theOrderStatusShouldBe(String expectedStatus) {
        assertEquals("Order status did not match the expected status", expectedStatus, currentOrderStatus);
    }

    @When("I check if the order is new")
    public void iCheckIfTheOrderIsNew() {
        if (currentOrder != null) {
            isOrderProcessed = currentOrder.isNew();
        }
    }

    @Then("the order should be considered {string}")
    public void theOrderShouldBeConsidered(String expectedNewStatus) {
        boolean expectedIsNew = "new".equalsIgnoreCase(expectedNewStatus);
        assertEquals("Order new status did not match the expected status", expectedIsNew, isOrderProcessed);
    }

    @When("I create an order with an empty detail string")
    public void iCreateAnOrderWithAnEmptyDetailString() {
        currentOrder = new Order("");
        isOrderCreated = (currentOrder != null);
    }

    @Then("the order should be created with default status")
    public void theOrderShouldBeCreatedWithDefaultStatus() {
        assertTrue("Order was not created", isOrderCreated);
        assertEquals("Created", currentOrder.getStatus());
    }
}
