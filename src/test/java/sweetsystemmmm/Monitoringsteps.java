package sweetsystemmmm;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Mysweetsystem2024.MyApplication;
import Mysweetsystem2024.Test;

import static org.junit.Assert.*;

public class Monitoringsteps {

    private Test system; // This should be your application class or service for interacting with the system
    private String financialReport;
    private String bestSellingProductsReport;
    private String userStatisticsReport;
    private  MyApplication app;
    public Monitoringsteps(MyApplication app) {
    	this.app=app;
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

        // Example of expected values (you should adapt these based on your actual data)
        String expectedTotalProfits = "Total Profits: $10000"; 

        // Verify that the total profits are correctly displayed
        assertTrue("Financial report does not contain expected total profits",
                   financialReport.contains(expectedTotalProfits));
        
        // Optionally, you can check for additional details or specific content in the report
        assertTrue("Financial report does not contain expected detailed report",
                   financialReport.contains("Detailed Report:"));
        
        // If your report has a specific structure, you can further assert on parts of the report
        String[] lines = financialReport.split("\n");
        assertTrue("Financial report is missing total profits line",
                   lines[0].contains(expectedTotalProfits));

        // If there are more expected details, you can assert them similarly
        assertTrue("Financial report is missing expected details",
                   financialReport.contains("Details here")); // Adjust as needed
    }

    @Then("I should see a detailed financial report")
    public void iShouldSeeADetailedFinancialReport() {
        assertNotNull(financialReport); // Check that the report is detailed
        // Add assertions to verify the details of the report
    }

    @When("I navigate to the Store Reports section")
    public void iNavigateToTheStoreReportsSection() {
        system.navigateToSection("Store Reports"); // Method to navigate to the section
    }

    @When("I request the best-selling products report for all stores")
    public void iRequestTheBestSellingProductsReportForAllStores() {
        bestSellingProductsReport = system.requestBestSellingProductsReport(); // Method to request the best-selling products report
    }

    @Then("I should see a list of best-selling products for each store")
    public void iShouldSeeAListOfBestSellingProductsForEachStore() {
        assertNotNull(bestSellingProductsReport); // Check that the report was generated
        // Add assertions to verify the content of the report
    }

    @Then("the list should include the product names and sales figures")
    public void theListShouldIncludeTheProductNamesAndSalesFigures() {
        assertNotNull(bestSellingProductsReport); // Check that the report contains the necessary information
        // Add more detailed assertions based on your report format
    }

    @When("I navigate to the User Statistics section")
    public void iNavigateToTheUserStatisticsSection() {
        system.navigateToSection("User Statistics"); // Method to navigate to the section
    }

    @When("I request user statistics by city")
    public void iRequestUserStatisticsByCity() {
        userStatisticsReport = system.requestUserStatisticsByCity(); // Method to request user statistics by city
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
