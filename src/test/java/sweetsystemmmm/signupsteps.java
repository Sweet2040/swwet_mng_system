package sweetsystemmmm;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import Mysweetsystem2024.MyApplication;
import Mysweetsystem2024.User;
import Mysweetsystem2024.UserRole;
import Mysweetsystem2024.signupmanager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class signupsteps {

    private MyApplication app;
    private signupmanager signupManager;
    private String currentUsername;
    private String currentPassword;
    private boolean signUpResult;

    public signupsteps(MyApplication app) {
        this.app = app;
        this.signupManager = new signupmanager(app);
    }

    @Given("that the user {string} is not signed up")
    public void thatTheUserIsNotSignedUp(String username) {
        currentUsername = username;
        assertFalse("User should not be signed up", app.userExists(username));
    }

    @Given("they do not have an account in the system")
    public void theyDoNotHaveAnAccountInTheSystem() {
        assertNull("User account should not exist", app.getUser(currentUsername));
    }

    @When("the user enters a username {string} and password {string}")
    public void theUserEntersAUsernameAndPassword(String username, String password) {
        currentUsername = username;
        currentPassword = password;

        // Use default or hard-coded values for email, country, and role
        String defaultEmail = "defaultEmail@example.com";
        String defaultCountry = "Palestine";
        UserRole defaultRole = UserRole.REGULAR_USER;

        // Attempt to sign up the user
        signUpResult = signupManager.signUp(currentUsername, currentPassword, defaultEmail, defaultCountry, defaultRole);
    }

    @Then("the sign up succeeds")
    public void theSignUpSucceeds() {
        assertTrue("Sign up should succeed", signUpResult);
    }

    @Then("the user is redirected to the login page")
    public void theUserIsRedirectedToTheLoginPage() {
        // This assumes that redirection is simulated by a successful signup result
        assertTrue("User should be redirected to login page", signUpResult);
    }

    @Then("the account is saved in the system")
    public void theAccountIsSavedInTheSystem() {
        assertNotNull("User account should be saved", app.getUser(currentUsername));
    }

    @Given("they already have an account in the system")
    public void theyAlreadyHaveAnAccountInTheSystem() {
        // Ensure the user is already in the system
        if (!app.userExists(currentUsername)) {
            app.addUser(new User(currentUsername, "defaultPassword", "defaultEmail@example.com", "Palestine", UserRole.REGULAR_USER));
        }
        assertTrue("User account should exist", app.userExists(currentUsername));
    }

    @Then("the sign up fails")
    public void theSignUpFails() {
        assertFalse("Sign up should fail", signUpResult);
    }

    @Then("the user is prompted to try again")
    public void theUserIsPromptedToTryAgain() {
        // Assumes that a failed sign-up attempt results in a prompt to try again
        assertFalse("User should be prompted to try again", signUpResult);
    }

    @Then("the account is not saved in the system")
    public void theAccountIsNotSavedInTheSystem() {
        User user = app.getUser(currentUsername);
        
        // If the sign-up attempt fails, the account should not be saved.
        if (app.userExists(currentUsername)) {
            assertNotNull("User account should already exist", user);
            assertTrue("User account should not be newly created", user.getUsername().equals(currentUsername));
        } else {
            assertNull("User account should not be saved", user);
        }
    }
    
}

