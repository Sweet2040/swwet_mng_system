package Mysweetsystem2024;

import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class LoginManager {
    private final Map<String, User> users;
    private final Set<String> loggedInUsers; // To track logged-in users
    
    private String currentUser;

    
    
    
   

    public LoginManager(Map<String, User> users) {
        this.users = users;
        this.loggedInUsers = new HashSet<>();
    }

    public boolean login(String username, String password) {
        if (validateLogin(username, password)) {
            this.currentUser = username; // Set the currentUser to the logged-in username
            System.out.println("Login successful. Welcome, " + currentUser + "!");
            return true;
        } else {
            System.out.println("Login failed. Invalid username or password.");
            return false;
        }
    }

    private boolean validateLogin(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }

    public String getCurrentUser() {
        return currentUser;
    }

    
    

    public boolean logout(String username) {
        if (username == null) {
        	//System.out.println("Username cannot be null.");
            return false;
        }
        if (loggedInUsers.remove(username)) {
            return true;
        } else {
            System.out.println("User is not logged in.");
            return false;
        }
    }

    public boolean isUserLoggedIn(String username) {
        return loggedInUsers.contains(username);
    }
}

