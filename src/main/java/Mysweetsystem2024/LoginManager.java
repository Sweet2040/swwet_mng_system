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
        if (validateLogin(username, password)) {
             String currentUser = username;
             loggedInUsers.add(currentUser);
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
       

        if (loggedInUsers.remove(username)) {
            return true;
        
        }
    }
    

    public boolean isUserLoggedIn(String username) {
        return loggedInUsers.contains(username);
    }
}

