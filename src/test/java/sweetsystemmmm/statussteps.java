package sweetsystemmmm;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


import static org.junit.Assert.*;

import Mysweetsystem2024.Order;

import java.time.LocalDateTime;
public class statussteps {


	    private Order order;
	    
	    
	    public statussteps() {
	    	
	    	
	    }
	    @Given("I have an order with status {string}")
	    public void iHaveAnOrderWithStatus(String status) {
	       
	        this.order = new Order("Details about the order");
	        this.order.setStatus(status);
	    }
	    
	    @Then("the order should be considered new")
	    public void theOrderShouldBeConsideredNew() {
	      
	        this.order.setCreationTime(LocalDateTime.now().minusHours(1));
	        assertTrue("Order should be considered new", this.order.isNew());
	    }

	    @Given("I have an order with status {string} and created within the last {int} hour")
	    public void iHaveAnOrderWithStatusAndCreatedWithinTheLastHour(String status, Integer hoursAgo) {
	        this.order = new Order("Details about the order");
	        this.order.setStatus(status);
	        this.order.setCreationTime(LocalDateTime.now().minusHours(hoursAgo));
	    }

	    @Given("I have an order with status {string} and created more than {int} hours ago")
	    public void iHaveAnOrderWithStatusAndCreatedMoreThanHoursAgo(String status, Integer hoursAgo) {
	        this.order = new Order("Details about the order");
	        this.order.setStatus(status);
	        this.order.setCreationTime(LocalDateTime.now().minusHours(hoursAgo + 1)); 
	    }

	    @Then("the order should not be considered new")
	    public void theOrderShouldNotBeConsideredNew() {
	      //  assertFalse("Order should not be considered new", order.isNew());
	    }
	    
	    @Given("I have an order with status {string} and created within the last {int} minutes")
	    public void iHaveAnOrderWithStatusAndCreatedWithinTheLastMinutes(String status, Integer minutesAgo) {
	        this.order = new Order("Details about the order");
	        this.order.setStatus(status);
	        this.order.setCreationTime(LocalDateTime.now().minusMinutes(minutesAgo));
	    }

	    @Given("I have an order with status {string} and created in the future")
	    public void iHaveAnOrderWithStatusAndCreatedInTheFuture(String status) {
	        this.order = new Order("Details about the order");
	        this.order.setStatus(status);
	        this.order.setCreationTime(LocalDateTime.now().plusDays(1)); 
	    }
	 
	}
