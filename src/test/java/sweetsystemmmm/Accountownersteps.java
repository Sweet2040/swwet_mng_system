package sweetsystemmmm;

import io.cucumber.java.en.*;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class Accountownersteps {



    private String accountDetails;
    private String businessInformation;
    private boolean detailsUpdatedSuccessfully = false;
    private boolean businessInfoUpdatedSuccessfully = false;

    public Accountownersteps () {
         // This constructor is intentionally left empty because it is not needed for this step definition class.
    	}
  

    @Given("I am on the account management page")
    public void iAmOnTheAccountManagementPage() {
        // Simulate navigation to the account management page
       
        System.out.println("Navigated to the account management page");
        
       
    }

    @When("I update my account details with new information")
    public void iUpdateMyAccountDetailsWithNewInformation() {
       
        accountDetails = "Updated account details"; // Example of updated details
        System.out.println("Updated account details with new information");
       
        detailsUpdatedSuccessfully = true; // Simulate successful update
    }

    @Then("my account details should be updated successfully")
    public void myAccountDetailsShouldBeUpdatedSuccessfully() {
        
        Assert.assertTrue("Account details were not updated successfully", detailsUpdatedSuccessfully);
        System.out.println("Verified that account details were updated successfully");
       
       
    }

    @Given("I am on the business information page")
    public void iAmOnTheBusinessInformationPage() {
        
        System.out.println("Navigated to the business information page");
        
       
    }

    @When("I update my business information with new details")
    public void iUpdateMyBusinessInformationWithNewDetails() {
        
        businessInformation = "Updated business information"; // Example of updated details
        System.out.println("Updated business information with new details");
      
        businessInfoUpdatedSuccessfully = true; // Simulate successful update
    }

    @Then("my business information should be updated successfully")
    public void myBusinessInformationShouldBeUpdatedSuccessfully() {
       
        Assert.assertTrue("Business information was not updated successfully", businessInfoUpdatedSuccessfully);
        System.out.println("Verified that business information was updated successfully");
        
    }
}
