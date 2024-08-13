Feature: Communication and Notification

  As a Store Owner or Raw Material Supplier
  I want to use the messaging system to communicate with users and other suppliers
  So that I can effectively manage communication and stay informed of important updates

  Scenario: Store Owner sends a message to a supplier
    Given I am logged in as a Store Owner
    When I click on "Send Message"
    And I select "Supplier" as the recipient type
    And I choose a supplier from the list
    And I enter the message subject and body
    And I click "Send"
    Then the message should be sent to the selected supplier

  Scenario: Raw Material Supplier sends a message to a Store Owner
    Given I am logged in as a Raw Material Supplier
    When I click on "Send Message"
    And I select "Store Owner" as the recipient type
    And I choose a store owner from the list
    And I enter the message subject and body
    And I click "Send"
    Then the message should be sent to the selected store owner

  Scenario: Special request email notification
    Given a special request is made by a user
    When the request is submitted
    Then the system should send an email notification to the store owner
    And the email should contain the details of the special request
    And the store owner should be able to view the notification in their inbox

  Scenario: Special request email notification for a supplier
    Given a special request is made by a store owner
    When the request is submitted
    Then the system should send an email notification to the raw material supplier
    And the supplier should be able to view the notification in their inbox

