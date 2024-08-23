package sweetsystemmmm;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import Mysweetsystem2024.User;
import io.cucumber.java.en.*;
public class commusersteps {
	





		    private User user;
		    private String confirmationMessage;
		    private boolean feedbackRecorded;

		    @Given("I am logged in as a registered user")
		    public void iAmLoggedInAsARegisteredUser() {
		        user = new User("registeredUser"); // Simulate user login
		        assertNotNull("User should be logged in", user);
		    }

		    @When("I navigate to the store owner's page")
		    public void iNavigateToTheStoreOwnersPage() {
		        // Simulate navigating to the store owner's page
		    }

		    @When("I send a message to the store owner with the subject {string} and message {string}")
		    public void iSendAMessageToTheStoreOwnerWithTheSubjectAndMessage(String subject, String message) {
		        // Simulate sending a message to the store owner
		        confirmationMessage = user.sendMessageToStoreOwner(subject, message);
		        assertNotNull("Confirmation message should not be null", confirmationMessage);
		    }

		    @Then("the message should be sent to the store owner")
		    public void theMessageShouldBeSentToTheStoreOwner() {
		        assertTrue("The message should be sent successfully", confirmationMessage.contains("Message sent to store owner"));
		    }

		    @Then("I should receive a confirmation of the message being sent")
		    public void iShouldReceiveAConfirmationOfTheMessageBeingSent() {
		        assertNotNull("Confirmation message should be received", confirmationMessage);
		    }

		    @When("I navigate to the purchased products page")
		    public void iNavigateToThePurchasedProductsPage() {
		        // Simulate navigating to the purchased products page
		    }

		    @When("I select a product to provide feedback on")
		    public void iSelectAProductToProvideFeedbackOn() {
		        // Simulate selecting a product for feedback
		    }

		    @When("I submit feedback with the rating {string} and the comment {string}")
		    public void iSubmitFeedbackWithTheRatingAndTheComment(String rating, String comment) {
		        // Simulate submitting feedback on the product
		        feedbackRecorded = user.submitProductFeedback(rating, comment);
		        assertTrue("Feedback should be recorded", feedbackRecorded);
		    }

		    @Then("the feedback should be recorded successfully")
		    public void theFeedbackShouldBeRecordedSuccessfully() {
		        assertTrue("Feedback should be recorded successfully", feedbackRecorded);
		    }

		    @Then("the store owner should be notified of the feedback")
		    public void theStoreOwnerShouldBeNotifiedOfTheFeedback() {
		        // Simulate notification to the store owner
		        String notification = user.notifyStoreOwner();
		        assertTrue("Store owner should be notified", notification.contains("Store owner notified of feedback"));
		    }

		    @When("I navigate to the shared recipes page")
		    public void iNavigateToTheSharedRecipesPage() {
		        // Simulate navigating to the shared recipes page
		    }

		    @When("I select a recipe to provide feedback on")
		    public void iSelectARecipeToProvideFeedbackOn() {
		        // Simulate selecting a recipe for feedback
		    }

		    @Then("the recipe owner should be notified of the feedback")
		    public void theRecipeOwnerShouldBeNotifiedOfTheFeedback() {
		        // Simulate notification to the recipe owner
		        String notification = user.notifyRecipeOwner();
		        assertTrue("Recipe owner should be notified", notification.contains("Recipe owner notified of feedback"));
		    }
		}

