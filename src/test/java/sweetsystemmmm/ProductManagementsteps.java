package sweetsystemmmm;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import Mysweetsystem2024.ProductMgt;

public class ProductManagementsteps {
    private ProductMgt productManagement;
    private String productName;
    private String productDescription;
    private double productPrice;
    private double updatedPrice;
    private double discountValue;
    private String message;
   

    public ProductManagementsteps( ) {
        productManagement = new ProductMgt();
    
    }
    
    
    
    
    
    
    
    
    
    
    @Given("the store owner or supplier is signed in")
    public void theStoreOwnerOrSupplierIsSignedIn() {
       //not impl
    }

    @When("they add a new product with name {string}, description {string}, and price {string}")
    public void theyAddANewProductWithNameDescriptionAndPrice(String name, String description, String price) {
        productName = name;
        productDescription = description;
        productPrice = Double.parseDouble(price);
        boolean success = productManagement.addProduct(productName, productDescription, productPrice);
        message = success ? "Product added successfully." : "Failed to add product.";
        System.out.println(message);
    }

    @Then("the product should be added successfully")
    public void theProductShouldBeAddedSuccessfully() {
        assert "Product added successfully.".equals(message);
    }

    @Then("a confirmation message should be displayed")
    public void aConfirmationMessageShouldBeDisplayed() {
        // This is already covered
    }

    @Given("the store owner or supplier is signed in and has an existing product")
    public void theStoreOwnerOrSupplierIsSignedInAndHasAnExistingProduct() {
       
        boolean added = productManagement.addProduct("cake cake", " delicious", 100.0);
        if (!added) {
           
            System.out.println("Product already exists or failed to add.");
        }
    }

    @When("they update the product with name {string} to {string} and change the price to {string}")
    public void theyUpdateTheProductWithNameToAndChangeThePriceTo(String name, String newDescription, String newPrice) {
    
    	 productName = name;
    	    productDescription = newDescription;
    	    updatedPrice = Double.parseDouble(newPrice);

    	    
    	    if (!productManagement.productExists(productName)) {
    	     
    	        productManagement.addProduct(productName, "Initial Description", 100.0);
    	    }

    	   boolean success = productManagement.updateProduct(productName, productDescription, updatedPrice);
    	   message = success ? "Product updated successfully." : "Failed to update product.";
    }

    @Then("the product details should be updated successfully")
    public void theProductDetailsShouldBeUpdatedSuccessfully() {
        assert "Product updated successfully.".equals(message);
    	
    }

    
    
    
    
    
    
    

    @When("they remove the product with name {string}")
    public void theyRemoveTheProductWithName(String name) {
        productName = name;

        
        boolean productExistsBefore = productManagement.productExists(productName);
        if (!productExistsBefore) {
        
            boolean added = productManagement.addProduct(productName, "Initial Description", 100.0);
            if (!added) {
                throw new RuntimeException("Failed to add product before removal attempt.");
            }
        }

      
        System.out.println("Product exists before removal: " + productManagement.productExists(productName));

        boolean success = productManagement.removeProduct(productName);
        message = success ? "Product removed successfully." : "Failed to remove product.";

       
        System.out.println(message);
    }


    @Then("the product should be removed successfully")
    public void theProductShouldBeRemovedSuccessfully() {
      
        assert "Product removed successfully.".equals(message) : "Expected success message for product removal but got: " + message;

        
        boolean productExistsAfter = productManagement.productExists(productName);
        System.out.println("Product exists after removal attempt: " + productExistsAfter);
        assert !productExistsAfter : "Expected product to be removed but it still exists.";
    }

    
    
    
    
    
    

    @When("they view the sales and profits report")
    public void theyViewTheSalesAndProfitsReport() {
      
    	String report = productManagement.getBestSellingProductsReport();
        message = report.contains("Best Selling Products") ? "Report displayed successfully." : "Failed to display report.";
        System.out.println("Report Content:\n" + report); // Debug output
    }

    @Then("the report should display total sales and profits")
    public void theReportShouldDisplayTotalSalesAndProfits() {
        assert "Report displayed successfully.".equals(message);
    }

    @Then("a breakdown of sales per product")
    public void aBreakdownOfSalesPerProduct() {
       
        assert "Report displayed successfully.".equals(message) : "Expected success message but got: " + message;
        
     
        String report = productManagement.getSalesAndProfitsReport();
        
        System.out.println("Report Content:\n" + report);
        
      
        assert report.contains("Sales Breakdown") : "Expected report to contain 'Sales Breakdown' but it does not.";
    }

    
    
    
    
    
    
    @When("they view the best-selling products report")
    public void theyViewTheBestSellingProductsReport() {
        String report = productManagement.getBestSellingProductsReport();
        message = report.contains("Best Selling Products") ? "Report displayed successfully." : "Failed to display report.";
        
    }

    @Then("the report should display a list of best-selling products")
    public void theReportShouldDisplayAListOfBestSellingProducts() {
    
    	
    	 assert "Report displayed successfully.".equals(message) : "Expected success message for best-selling products report but got: " + message;
    	
    	
    	
    	
    }

    @Then("their respective sales figures")
    public void theirRespectiveSalesFigures() {
    	
        String report = productManagement.getBestSellingProductsReport();
        
        
        assert report != null : "Report is null";
        assert !report.isEmpty() : "Report is empty";
        
     
        System.out.println("Report Content:\n" + report);
        
       
        assert report.contains("Best Selling Products") : "Expected report to contain 'Best Selling Products' but it does not.";
        assert report.contains("cake: $150") : "Expected report to contain sales figure for cake but it does not.";
        assert report.contains("cinamon: $200") : "Expected report to contain sales figure for cinamon but it does not.";
        assert report.contains("chocklate: $250") : "Expected report to contain sales figure for chocklate but it does not.";
    }


    
    
    
    
    
    
    
    
    
    @When("they apply a dynamic discount to a product with name {string} and discount {string}")
    public void theyApplyADynamicDiscountToAProductWithNameAndDiscount(String name, String discount) {
        productName = name;

        try {
            
            discount = discount.replace("%", "").trim();
            discountValue = Double.parseDouble(discount);
        } catch (NumberFormatException e) {
         
            message = "Invalid discount format.";
            System.out.println("Error parsing discount: " + e.getMessage());
            return; 
        }

        
        System.out.println("Checking if product exists: " + productName);
        boolean productExists = productManagement.productExists(productName);
        if (!productExists) {
           
            boolean added = productManagement.addProduct(productName, "Initial Description", 100.0);
            if (!added) {
                message = "Failed to add product.";
                System.out.println("Product could not be added: " + productName);
                return;
            }
        }

        
        boolean success = productManagement.applyDiscount(productName, discountValue);
        message = success ? "Discount applied successfully." : "Failed to apply discount.";
        System.out.println(message);
    }

    

    @Then("the discount should be applied successfully")
    public void theDiscountShouldBeAppliedSuccessfully() {
     
    	 assert "Discount applied successfully.".equals(message) : "Expected success message for discount application but got: " + message;
    	 
    }

    @Then("the new price should reflect the discount")
    public void theNewPriceShouldReflectTheDiscount() {

        double initialPrice = 100.0;
        double expectedPrice = initialPrice - (initialPrice * (discountValue / 100));
        
        
        double actualPrice = productManagement.getProductPrice(productName);

      
        assert Math.abs(expectedPrice - actualPrice) < 0.01 : "Expected price: " + expectedPrice + ", but got: " + actualPrice;
    }

}
