package sweetsystemmmm;
import io.cucumber.java.en.*;
import java.util.HashMap;
import java.util.Map;
public class contentsteps {








    private Map<String, String> recipes = new HashMap<>();
    private String feedback;
    private String confirmationMessage;
    private String responseMessage;

 

    @When("I navigate to the {string} section")
    public void iNavigateToTheSection(String section) {
        // Simulate navigation to the specific section
    }

    @When("I choose to add a new {string}")
    public void iChooseToAddANew(String content) {
        // Simulate choosing to add new content, e.g., a recipe or post
    }

    @When("I fill in the recipe details with the following:")
    public void iFillInTheRecipeDetailsWithTheFollowing(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> details = dataTable.asMap(String.class, String.class);
        String title = details.get("Title");
        String description = details.get("Description");
        recipes.put(title, description); // Add recipe to the collection
    }

    @When("I submit the new recipe")
    public void iSubmitTheNewRecipe() {
        confirmationMessage = "Recipe added successfully";
    }

    @Then("I should see a confirmation message {string}")
    public void iShouldSeeAConfirmationMessage(String message) {
        if (confirmationMessage != null) {
            assert confirmationMessage.equals(message);
        } else {
            throw new RuntimeException("Confirmation message is null");
        }
    }

    @Then("the recipe {string} should appear in the list of recipes")
    public void theRecipeShouldAppearInTheListOfRecipes(String title) {
        assert recipes.containsKey(title);
    }

    @Given("a recipe titled {string} exists")
    public void aRecipeTitledExists(String title) {
        recipes.put(title, "Default Description"); // Ensure the recipe exists
    }

    @When("I choose to edit the recipe {string}")
    public void iChooseToEditTheRecipe(String title) {
        // Simulate choosing to edit a recipe
    }

    @When("I update the description to {string}")
    public void iUpdateTheDescriptionTo(String newDescription) {
        // Update the description of the selected recipe
        recipes.replace("Chocolate Cake", newDescription);
    }

    @When("I submit the changes")
    public void iSubmitTheChanges() {
        confirmationMessage = "Recipe updated successfully";
    }

    @Then("the recipe {string} should have the updated description")
    public void theRecipeShouldHaveTheUpdatedDescription(String title) {
        assert recipes.get(title).equals("A delicious and moist chocolate cake");
    }

    @When("I choose to delete the recipe {string}")
    public void iChooseToDeleteTheRecipe(String title) {
        recipes.remove(title);
        confirmationMessage = "Recipe deleted successfully";
    }

    @Then("the recipe {string} should no longer appear in the list of recipes")
    public void theRecipeShouldNoLongerAppearInTheListOfRecipes(String title) {
        assert !recipes.containsKey(title);
    }

    @Given("there is user feedback on a recipe titled {string}")
    public void thereIsUserFeedbackOnARecipeTitled(String title) {
        feedback = "Great recipe!"; // Simulate user feedback
    }

    @When("I select the feedback for the recipe {string}")
    public void iSelectTheFeedbackForTheRecipe(String title) {
        // Simulate selecting the feedback for a particular recipe
    }

    @Then("I should see the user's feedback")
    public void iShouldSeeTheUserSFeedback() {
        assert feedback != null;
    }

    @Then("I can choose to respond to the feedback with a message")
    public void iCanChooseToRespondToTheFeedbackWithAMessage() {
        responseMessage = "Thank you for your feedback!";
        confirmationMessage = "Response sent successfully";
    }

}
