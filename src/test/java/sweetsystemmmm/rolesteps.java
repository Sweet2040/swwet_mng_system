package sweetsystemmmm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import Mysweetsystem2024.UserRole;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class rolesteps {
	

	

	    private String roleString;
	    private UserRole role;
	    private Exception exception;

	    @Given("a user role string {string}")
	    public void aUserRoleString(String roleString) {
	        this.roleString = roleString;
	    }

	    @Given("a null user role string")
	    public void aNullUserRoleString() {
	        this.roleString = null;
	    }

	    @When("I convert the string to a UserRole")
	    public void iConvertTheStringToAUserRole() {
	        try {
	            role = UserRole.fromString(roleString);
	        } catch (Exception e) {
	            this.exception = e;
	        }
	    }

	    @Then("the result should be {string}")
	    public void theResultShouldBe(String expectedRole) {
	        assertEquals(UserRole.valueOf(expectedRole), role);
	    }

	    @Then("an IllegalArgumentException should be thrown")
	    public void anIllegalArgumentExceptionShouldBeThrown() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            if (exception != null) throw exception;
	        });
	    }

	    @Then("a NullPointerException should be thrown")
	    public void aNullPointerExceptionShouldBeThrown() {
	        assertThrows(NullPointerException.class, () -> {
	            if (exception != null) throw exception;
	        });
	    }
	}


