Feature: Order Status

  Background:
    Given I am logged in as a Store Owner or Raw Material Supplier
    And I am on the order management page

  Scenario: Check if order is new with status "new"
    Given I have an order with status "new"
    Then the order should be considered new

  Scenario: Check if order is new with status "shipped" but created within the last 1 hour
    Given I have an order with status "shipped" and created within the last 1 hour
    Then the order should be considered new

  Scenario: Check if order is not new with status "shipped" and created more than 24 hours ago
    Given I have an order with status "shipped" and created more than 24 hours ago
    Then the order should not be considered new

  Scenario: Check if order is new with status "shipped" but created within the last 10 minutes
    Given I have an order with status "shipped" and created within the last 10 minutes
    Then the order should be considered new

  Scenario: Check if order is not new with status "shipped" and created in the future
    Given I have an order with status "shipped" and created in the future
    Then the order should not be considered new
