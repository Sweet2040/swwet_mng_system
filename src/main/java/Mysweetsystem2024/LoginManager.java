package Mysweetsystem2024;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class LoginManager {
     private static final Logger logger = Logger.getLogger(LoginManager.class.getName());
    private final Map<String, User> users;
    private final Set<String> loggedInUsers;
    private String currentUser;
    public LoginManager(Map<String, User> users) {
        this.users = users;
        this.loggedInUsers = new HashSet<>();
    }

  public boolean login(String username, String password) {
        if (validateLogin(username, password)) {
            this.currentUser = username;
            logger.log(Level.INFO, "Login successful. Welcome, {0}!", currentUser);
            return true;
        } else {
            logger.log(Level.WARNING, "Login failed. Invalid username or password.");
            return false;
        }
    }
    
    private boolean validateLogin(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }

     public boolean logout(String username) {
        if (username == null) {
            logger.log(Level.WARNING, "Logout attempt failed: username is null.");
            return false;
        }

        if (loggedInUsers == null) {
            logger.log(Level.WARNING, "Logout attempt failed: loggedInUsers set is null.");
            return false;
        }

        if (loggedInUsers.remove(username)) {
            logger.log(Level.INFO, "User {0} logged out successfully.", username);
            return true;
        } else {
            logger.log(Level.WARNING, "Logout attempt failed: User {0} is not logged in.", username);
            return false;
        }
    }

    public boolean isUserLoggedIn(String username) {
        return loggedInUsers.contains(username);
    }
}
