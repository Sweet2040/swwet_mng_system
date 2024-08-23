Feature: Order Management
  As a Store Owner or Raw Material Supplier
  I want to process and track orders
  So that I can manage and monitor orders efficiently

  Background:
    Given I am logged in as a Store Owner or Raw Material Supplier
    And I am on the order management page

  Scenario: Create a new order
    When I create a new order with details "Order for raw materials"
    Then the order should be processed successfully

  Scenario: Update order status
    Given I have created an order with details "Order for raw materials"
    When I update the status of the order to "Shipped"
    Then the order status should be "Shipped"
    
  Scenario: Verify order status after processing
    Given I have created an order with details "Order for raw materials"
    When I update the status of the order to "Delivered"
    Then the order status should be "Delivered"
    
    
    
    
    Scenario: Verify order string representation
    Given I have created an order with details "Order for raw materials"
    When I call the toString method on the order
    Then the string representation of the order should be "Order{orderId='null', status='Created', productName='null', quantity='null', customerName='null', storeOwnerName='null'}"
    
    
    
    
    
    
  Scenario: Set and Get Order Details
    Given I have an empty order
    When I set the order ID to "12345"
    And I set the status to "Processing"
    And I set the product name to "Chocolate Cake"
    And I set the quantity to "10"
    And I set the customer name to "John Doe"
    And I set the store owner name to "Bakery Store"
    Then the order ID should be "12345"
    And the status should be "Processing"
    And the product name should be "Chocolate Cake"
    And the quantity should be "10"
    And the customer name should be "John Doe"
    And the store owner name should be "Bakery Store"
