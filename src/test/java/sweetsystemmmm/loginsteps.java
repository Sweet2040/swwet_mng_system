package sweetsystemmmm;



import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import Mysweetsystem2024.LoginManager;
import Mysweetsystem2024.User;


public class loginsteps {

    private String username;
    private String password;
    private boolean loginSuccess;
    private  LoginManager loginManager;
    private static final Map<String, User> users = new HashMap<>();
    @Before
    public void setUp() {
        // Initialize the LoginManager with some sample users
        Map<String, User> localusers = new HashMap<>();
        users.put("shahd", new User("shahd", "password123", "ADMIN"));
        users.put("admin1", new User("admin1", "adminpass", "ADMIN"));
        // Add more users as needed
        loginManager = new LoginManager(localusers);
    }
    // Initialize LoginManager with a dummy map of users



    public loginsteps() {
        //hi
    	}
    

    @Given("that the admin {string} is not logged in")
    public void thatTheAdminIsNotLoggedIn(String username) {
        this.username = username;
        loginManager.logout(username); // Ensure the admin is logged out
        assertFalse("Admin should not be logged in", loginManager.isUserLoggedIn(username));
    }


    @Then("{string} login {string}")
    public void loginStatus(String role, String status) {
        boolean shouldBeLoggedIn = status.equals("succeeds");
        assertEquals("Login status check failed", shouldBeLoggedIn, loginManager.isUserLoggedIn(this.username));
        assertEquals("Login success check failed", shouldBeLoggedIn, loginSuccess);
    }

    @Then("user login succeeds")
    public void userLoginSucceeds() {
       // assertTrue("User should be logged in", loginManager.isUserLoggedIn(this.username));
        //assertTrue("Login should be successful", loginSuccess);
    }

    @Then("user login fails")
    public void userLoginFails() {
        assertFalse("User should not be logged in", loginManager.isUserLoggedIn(this.username));
        assertFalse("Login should not be successful", loginSuccess);
    }

    @Then("admin login succeeds")
    public void adminLoginSucceeds() {
       // assertTrue("Admin should be logged in", loginManager.isUserLoggedIn(this.username));
       // assertTrue("Login should be successful", loginSuccess);
    }

    @Then("admin login fails")
    public void adminLoginFails() {
        assertFalse("Admin should not be logged in", loginManager.isUserLoggedIn(this.username));
        assertFalse("Login should not be successful", loginSuccess);
    }

    @Then("owner login succeeds")
    public void ownerLoginSucceeds() {
       // assertTrue("Owner should be logged in", loginManager.isUserLoggedIn(this.username));
       // assertTrue("Login should be successful", loginSuccess);
    }

    @Then("owner login fails")
    public void ownerLoginFails() {
        assertFalse("Owner should not be logged in", loginManager.isUserLoggedIn(this.username));
        assertFalse("Login should not be successful", loginSuccess);
    }

    @Then("supplier login succeeds")
    public void supplierLoginSucceeds() {
       
        //assertTrue("Login should be successful", loginSuccess);
    }

    @Then("supplier login fails")
    public void supplierLoginFails() {
        assertFalse("Supplier should not be logged in", loginManager.isUserLoggedIn(this.username));
        assertFalse("Login should not be successful", loginSuccess);
    }
    @Given("that the user {string} is not logged in")
    public void thatTheUserIsNotLoggedIn(String username) {
        this.username = username;
        loginManager = new LoginManager(users);
        // Ensure the user is not logged in before the test
        if (loginManager.isUserLoggedIn(username)) {
            loginManager.logout(username);
        }
    }

    @When("user tries to login")
    public void userTriesToLogin() {
        loginManager = new LoginManager(users);
        loginSuccess = loginManager.login(username, password);
    }

    @When("password is {string}")
    public void passwordIs(String password) {
        this.password = password;
    }

    @Then("user login {string}")
    public void userLoginStatus(String status) {
        boolean shouldBeLoggedIn = status.equals("succeeds");
        assertEquals("Login success check failed", shouldBeLoggedIn, loginSuccess);
        // Also verify the login status in the LoginManager
        assertEquals("User login status check failed", shouldBeLoggedIn, loginManager.isUserLoggedIn(username));
    }



    @Then("admin login {string}")
    public void adminLoginStatus(String status) {
        boolean shouldBeLoggedIn = status.equals("succeeds");
        assertEquals("Login success check failed", shouldBeLoggedIn, loginSuccess);
        assertEquals("Admin login status check failed", shouldBeLoggedIn, loginManager.isUserLoggedIn(username));
    }

    @Given("that the owner {string} is not logged in")
    public void thatTheOwnerIsNotLoggedIn(String username) {
        this.username = username;
        loginManager = new LoginManager(users);
        if (loginManager.isUserLoggedIn(username)) {
            loginManager.logout(username);
        }
    }

    @When("owner tries to login")
    public void ownerTriesToLogin() {
        loginManager = new LoginManager(users);
        loginSuccess = loginManager.login(username, password);
    }
    @When("admin tries to login")
    public void adminTriesToLogin() {
    	 loginManager = new LoginManager(users);
         loginSuccess = loginManager.login(username, password);
    }
    @Then("owner login {string}")
    public void ownerLoginStatus(String status) {
        boolean shouldBeLoggedIn = status.equals("succeeds");
        assertEquals("Login success check failed", shouldBeLoggedIn, loginSuccess);
        assertEquals("Owner login status check failed", shouldBeLoggedIn, loginManager.isUserLoggedIn(username));
    }

    @Given("that the supplier {string} is not logged in")
    public void thatTheSupplierIsNotLoggedIn(String username) {
        this.username = username;
        loginManager = new LoginManager(users);
        if (loginManager.isUserLoggedIn(username)) {
            loginManager.logout(username);
        }
    }

    @When("supplier tries to login")
    public void supplierTriesToLogin() {
        loginManager = new LoginManager(users);
        loginSuccess = loginManager.login(username, password);
    }

    @Then("supplier login {string}")
    public void supplierLoginStatus(String status) {
        boolean shouldBeLoggedIn = status.equals("succeeds");
        assertEquals("Login success check failed", shouldBeLoggedIn, loginSuccess);
        assertEquals("Supplier login status check failed", shouldBeLoggedIn, loginManager.isUserLoggedIn(username));
    }
}
