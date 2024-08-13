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