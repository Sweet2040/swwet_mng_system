package Mysweetsystem2024;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class LoginManager {
    private final Map<String, User> users;
    private final Set<String> loggedInUsers; // To track logged-in users

     private static final Logger logger = Logger.getLogger(LoginManager.class.getName());
   


    public LoginManager(Map<String, User> users) {
        this.users = users;
        this.loggedInUsers = new HashSet<>();
    }

 public boolean login(String username, String password) {
    
    String correctUsername = "admin";
    String correctPassword = "password123";

  
    return username.equals(correctUsername) && password.equals(correctPassword);
}





   


  public boolean logout(String username) {
        if (username == null) {
            logger.log(Level.WARNING, "Username cannot be null.");
            return false;
        }
        if (loggedInUsers.remove(username)) {
            logger.log(Level.INFO, "User {0} logged out successfully.", username);
            return true;
        } else {
            logger.log(Level.WARNING, "User {0} is not logged in.", username);
            return false;
        }
    }
    

    public boolean isUserLoggedIn(String username) {
        return loggedInUsers.contains(username);
    }
}

