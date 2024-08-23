Feature: User Communication and Feedback
  As a registered user
  I want to directly communicate with store owners and suppliers
  So that I can inquire about products or seek assistance and provide feedback on purchased products and shared recipes

  Scenario: Communicate with a store owner
    Given I am logged in as a registered user
    When I navigate to the store owner's page
    And I send a message to the store owner with the subject "Product Inquiry" and message "Can you provide more details about this product?"
    Then the message should be sent to the store owner
    And I should receive a confirmation of the message being sent

  Scenario: Provide feedback on a purchased product
    Given I am logged in as a registered user
    When I navigate to the purchased products page
    And I select a product to provide feedback on
    And I submit feedback with the rating "5 stars" and the comment "Great product!"
    Then the feedback should be recorded successfully
    And the store owner should be notified of the feedback

  Scenario: Provide feedback on a shared recipe
    Given I am logged in as a registered user
    When I navigate to the shared recipes page
    And I select a recipe to provide feedback on
    And I submit feedback with the rating "4 stars" and the comment "Loved the recipe, but could use more seasoning"
    Then the feedback should be recorded successfully
    And the recipe owner should be notified of the feedback
