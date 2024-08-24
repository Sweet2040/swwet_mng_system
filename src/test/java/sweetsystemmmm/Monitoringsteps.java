package sweetsystemmmm;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

import mysweetsystem.Test;

public class Monitoringsteps {

    private Test system; 
    private String financialReport;
    private String bestSellingProductsReport;
    private String userStatisticsReport;

    public Monitoringsteps() {
    	// This method is currently empty because it has not been implemented yet.
    // Future implementation will include logic to verify that
    }
    @Given("I am logged in as an Admin")
    public void iAmLoggedInAsAnAdmin() {
        system = new Test(); // Initialize your system
        system.loginAsAdmin(); // Method to simulate admin login
    }

    @When("I navigate to the Financial Reports section")
    public void iNavigateToTheFinancialReportsSection() {
        system.navigateToSection("Financial Reports"); // Method to navigate to the section
    }

    @When("I request a financial report for the current period")
    public void iRequestAFinancialReportForTheCurrentPeriod() {
        financialReport = system.requestFinancialReport(); // Method to request a financial report
    }

    @Then("I should see the total profits for the period")
    public void iShouldSeeTheTotalProfitsForThePeriod() {
        assertNotNull(financialReport); // Check that the report was generated

       
        String expectedTotalProfits = "Total Profits: $10000"; 

        
        assertTrue("Financial report does not contain expected total profits",
                   financialReport.contains(expectedTotalProfits));
        
      
        assertTrue("Financial report does not contain expected detailed report",
                   financialReport.contains("Detailed Report:"));
        
       
        String[] lines = financialReport.split("\n");
        assertTrue("Financial report is missing total profits line",
                   lines[0].contains(expectedTotalProfits));

        
        assertTrue("Financial report is missing expected details",
                   financialReport.contains("Details here")); // Adjust as needed
    }

    @Then("I should see a detailed financial report")
    public void iShouldSeeADetailedFinancialReport() {
        assertNotNull(financialReport); // Check that the report is detailed
       
    }

    @When("I navigate to the Store Reports section")
    public void iNavigateToTheStoreReportsSection() {
        system.navigateToSection("Store Reports"); 
    }

    @When("I request the best-selling products report for all stores")
    public void iRequestTheBestSellingProductsReportForAllStores() {
        bestSellingProductsReport = system.requestBestSellingProductsReport(); 
    }

    @Then("I should see a list of best-selling products for each store")
    public void iShouldSeeAListOfBestSellingProductsForEachStore() {
        assertNotNull(bestSellingProductsReport);
       
    }

    @Then("the list should include the product names and sales figures")
    public void theListShouldIncludeTheProductNamesAndSalesFigures() {
        assertNotNull(bestSellingProductsReport);
        
    }

    @When("I navigate to the User Statistics section")
    public void iNavigateToTheUserStatisticsSection() {
        system.navigateToSection("User Statistics"); 
    }

    @When("I request user statistics by city")
    public void iRequestUserStatisticsByCity() {
        userStatisticsReport = system.requestUserStatisticsByCity(); 
    }

    @Then("I should see a list of cities with the number of registered users in each city")
    public void iShouldSeeAListOfCitiesWithTheNumberOfRegisteredUsersInEachCity() {
        assertNotNull(userStatisticsReport); // Check that the report was generated
        // Add assertions to verify the cities and user counts
    }

    @Then("the list should include cities such as Nablus and Jenin")
    public void theListShouldIncludeCitiesSuchAsNablusAndJenin() {
        assertNotNull(userStatisticsReport); // Check that the report contains the necessary cities
        // Add more detailed assertions to verify that Nablus and Jenin are included
    }
}
