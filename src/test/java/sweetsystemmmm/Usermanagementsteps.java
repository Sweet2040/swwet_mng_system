package sweetsystemmmm;

import static org.junit.Assert.*;

import Mysweetsystem2024.Admin;
import Mysweetsystem2024.StoreOwner;
import Mysweetsystem2024.User;
import Mysweetsystem2024.UserRepositry;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Usermanagementsteps {

    private Admin admin;
    private UserRepositry userRepository;
    private StoreOwner createdUser;
    private boolean isUserDeleted;

    @Given("I am logged in as an admin")
    public void iAmLoggedInAsAnAdmin() {
        userRepository = new UserRepositry();
        admin = new Admin(userRepository);
        System.out.println("Admin is logged in");
        assertNotNull("Admin should be initialized", admin);
    }

    @When("I create a new user account with the role {string}")
    public void iCreateANewUserAccountWithTheRole(String role) {
        createdUser = new StoreOwner("john_doe", "password123", "john@example.com", "USA", "John's Sweets", "123 Sweet St", "123-456-7890");
        boolean result = admin.createUser(createdUser.getUsername(), createdUser.getEmail());
        assertTrue("User account should be created", result);
        System.out.println("Creating a new user account with the role: " + role);
    }

    @Then("the user account should be successfully created")
    public void theUserAccountShouldBeSuccessfullyCreated() {
        User retrievedUser = userRepository.getUser(createdUser.getUsername());
        assertNotNull("User account should be successfully created", retrievedUser);
        System.out.println("User account was successfully created");
    }

    @Then("I should see the user in the list of store owners")
    public void iShouldSeeTheUserInTheListOfStoreOwners() {
        User retrievedUser = userRepository.getUser(createdUser.getUsername());
        assertNotNull("User should appear in the list of store owners", retrievedUser);
        System.out.println("User appears in the list of store owners");
    }

    @Given("a user with the role {string} exists")
    public void aUserWithTheRoleExists(String role) {
        createdUser = new StoreOwner("john_doe", "password123", "john@example.com", "USA", "John's Sweets", "123 Sweet St", "123-456-7890");
        userRepository.addUser(createdUser);
        User retrievedUser = userRepository.getUser(createdUser.getUsername());
        assertNotNull("A user with the role should exist", retrievedUser);
        System.out.println("A user with the role " + role + " exists");
    }

    @When("I edit the user's details")
    public void iEditTheUserSDetails() {
        createdUser.setStoreName("John's New Sweets");
        boolean result = admin.updateUser(createdUser);
        assertTrue("User details should be updated", result);
        System.out.println("Editing user's details");
    }

    @Then("the user's details should be successfully updated")
    public void theUserSDetailsShouldBeSuccessfullyUpdated() {
        User updatedUser = userRepository.getUser(createdUser.getUsername());
        assertEquals("John's New Sweets", ((StoreOwner) updatedUser).getStoreName());
        System.out.println("User's details were successfully updated");
    }

    @Then("I should see the updated details in the user list")
    public void iShouldSeeTheUpdatedDetailsInTheUserList() {
        User updatedUser = userRepository.getUser(createdUser.getUsername());
        assertEquals("John's New Sweets", ((StoreOwner) updatedUser).getStoreName());
        System.out.println("Updated details appear in the user list");
    }

    @When("I delete the user account")
    public void iDeleteTheUserAccount() {
        isUserDeleted = admin.deleteUser(createdUser.getUsername());
        assertTrue("User account should be deleted", isUserDeleted);
        System.out.println("User account has been deleted");
    }

    @Then("the user account should be successfully deleted")
    public void theUserAccountShouldBeSuccessfullyDeleted() {
        assertTrue("User account should be successfully deleted", isUserDeleted);
        User deletedUser = userRepository.getUser(createdUser.getUsername());
        assertNull("Deleted user should not be in the user database", deletedUser);
        System.out.println("User account was successfully deleted");
    }

    @Then("the user should no longer appear in the list of store owners")
    public void theUserShouldNoLongerAppearInTheListOfStoreOwners() {
        User deletedUser = userRepository.getUser(createdUser.getUsername());
        assertNull("User should no longer appear in the list of store owners", deletedUser);
        System.out.println("User no longer appears in the list of store owners");
    }
}
   
    
    

    
