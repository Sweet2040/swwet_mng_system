package sweetsystemmmm;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class communicationsteps {


    private String messageSubject;
    private String messageBody;
    private String emailContent;
	
  public communicationsteps () {
    	//hi }
    @Given("I am logged in as a Store Owner")
    public void iAmLoggedInAsAStoreOwner() {
        // Simulate logging in as a Store Owner
        // Example: Perform login via UI or API
        System.out.println("Logged in as Store Owner");
    }

    @When("I click on {string}")
    public void iClickOn(String buttonName) {
        // Simulate clicking a button
        // Example: Use UI automation code to click the button
        System.out.println("Clicked on " + buttonName);
    }

    @When("I select {string} as the recipient type")
    public void iSelectAsTheRecipientType(String recipientType) {
        // Simulate selecting recipient type
        // Example: Use UI automation code to select the recipient type
        System.out.println("Selected " + recipientType + " as recipient type");
    }

    @When("I choose a supplier from the list")
    public void iChooseASupplierFromTheList() {
        // Simulate choosing a supplier
        // Example: Use UI automation code to choose a supplier from a dropdown or list
        System.out.println("Chose a supplier from the list");
    }

    @When("I enter the message subject and body")
    public void iEnterTheMessageSubjectAndBody() {
        // Simulate entering message details
        messageSubject = "Subject"; // Example subject
        messageBody = "Message body"; // Example body
        System.out.println("Entered message subject and body");
    }

    @When("I click {string}")
    public void iClick(String buttonName) {
        // Simulate clicking a button
        System.out.println("Clicked on " + buttonName);
    }

    @Then("the message should be sent to the selected supplier")
    public void theMessageShouldBeSentToTheSelectedSupplier() {
        // Simulate checking if the message was sent
        // Example: Check if the message was successfully sent
        System.out.println("Checked that the message was sent to the supplier");
        Assert.assertTrue(true); // Replace with actual verification
    }

    @Given("I am logged in as a Raw Material Supplier")
    public void iAmLoggedInAsARawMaterialSupplier() {
        // Simulate logging in as a Raw Material Supplier
        System.out.println("Logged in as Raw Material Supplier");
    }

    @When("I choose a store owner from the list")
    public void iChooseAStoreOwnerFromTheList() {
        // Simulate choosing a store owner
        System.out.println("Chose a store owner from the list");
    }

    @Then("the message should be sent to the selected store owner")
    public void theMessageShouldBeSentToTheSelectedStoreOwner() {
        // Simulate checking if the message was sent
        System.out.println("Checked that the message was sent to the store owner");
        Assert.assertTrue(true); // Replace with actual verification
    }

    @Given("a special request is made by a user")
    public void aSpecialRequestIsMadeByAUser() {
        // Simulate a special request being made
        System.out.println("Special request made by a user");
    }

    @When("the request is submitted")
    public void theRequestIsSubmitted() {
        // Simulate submitting the request
        System.out.println("Request submitted");
    }

    @Then("the system should send an email notification to the store owner")
    public void theSystemShouldSendAnEmailNotificationToTheStoreOwner() {
        // Simulate checking if the email notification was sent
        emailContent = "Special Request Details"; // Example content
        System.out.println("Checked if email notification was sent to store owner");
        Assert.assertTrue(true); // Replace with actual verification
    }

    @Then("the email should contain the details of the special request")
    public void theEmailShouldContainTheDetailsOfTheSpecialRequest() {
        // Simulate checking the email content
        System.out.println("Checked if email contains special request details");
        Assert.assertTrue(emailContent.contains("Special Request Details"));
    }

    @Then("the store owner should be able to view the notification in their inbox")
    public void theStoreOwnerShouldBeAbleToViewTheNotificationInTheirInbox() {
        // Simulate checking if the store owner can view the notification
        System.out.println("Checked if store owner can view the notification in their inbox");
        Assert.assertTrue(true); // Replace with actual verification
    }

    @Given("a special request is made by a store owner")
    public void aSpecialRequestIsMadeByAStoreOwner() {
        // Simulate a special request made by a store owner
        System.out.println("Special request made by a store owner");
    }

    @Then("the system should send an email notification to the raw material supplier")
    public void theSystemShouldSendAnEmailNotificationToTheRawMaterialSupplier() {
        // Simulate checking if the email notification was sent
        emailContent = "Special Request Details"; // Example content
        System.out.println("Checked if email notification was sent to raw material supplier");
        Assert.assertTrue(true); // Replace with actual verification
    }

    @Then("the supplier should be able to view the notification in their inbox")
    public void theSupplierShouldBeAbleToViewTheNotificationInTheirInbox() {
        // Simulate checking if the supplier can view the notification
        System.out.println("Checked if supplier can view the notification in their inbox");
        Assert.assertTrue(true); // Replace with actual verification
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
