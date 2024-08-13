Feature: Content Management

  As an Admin,
  I want to manage the content shared on the system,
  So that I can ensure quality and relevance for users.

  Background:
    Given I am logged in as an Admin

  Scenario: Add a new recipe or post
    When I navigate to the "Content Management" section
    And I choose to add a new "Recipe"
    And I fill in the recipe details with the following:
      | Title           | Chocolate Cake        |
      | Description     | A rich chocolate cake |
      | Ingredients     | Chocolate, Flour, Eggs|
      | Instructions    | Mix, bake, serve      |
    And I submit the new recipe
    Then I should see a confirmation message "Recipe added successfully"
    And the recipe "Chocolate Cake" should appear in the list of recipes

  Scenario: Edit an existing recipe or post
    Given a recipe titled "Chocolate Cake" exists
    When I navigate to the "Content Management" section
    And I choose to edit the recipe "Chocolate Cake"
    And I update the description to "A delicious and moist chocolate cake"
    And I submit the changes
    Then I should see a confirmation message "Recipe updated successfully"
    And the recipe "Chocolate Cake" should have the updated description

  Scenario: Delete a recipe or post
    Given a recipe titled "Chocolate Cake" exists
    When I navigate to the "Content Management" section
    And I choose to delete the recipe "Chocolate Cake"
    Then I should see a confirmation message "Recipe deleted successfully"
    And the recipe "Chocolate Cake" should no longer appear in the list of recipes

  Scenario: View and respond to user feedback
    Given there is user feedback on a recipe titled "Chocolate Cake"
    When I navigate to the "Feedback Management" section
    And I select the feedback for the recipe "Chocolate Cake"
    Then I should see the user's feedback
    And I can choose to respond to the feedback with a message
    And I should see a confirmation message "Response sent successfully"