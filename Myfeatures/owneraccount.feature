Feature: Account Management

  As a Store Owner or Raw Material Supplier
  I want to manage my account details and update business information
  So that I can keep my account information up-to-date

  Background:
    Given I am logged in as a Store Owner or Raw Material Supplier

  Scenario: Update account details
    Given I am on the account management page
    When I update my account details with new information
    And I submit the changes
    Then my account details should be updated successfully

  Scenario: Update business information
    Given I am on the business information page
    When I update my business information with new details
    And I submit the changes
    Then my business information should be updated successfully
