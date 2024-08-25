package Mysweetsystem2024;


import java.io.*;

import java.util.HashMap;

import java.util.Map;

import javax.swing.*;





public class MyApplication {
    private Map<String, User> users;    
    private String currentUser; 

    
    
    
    
    

    public MyApplication() {
        users = new HashMap<>();
        
       
    }

    public void signUpUser(String username, String password, String email, String country, UserRole role) {
        if (!userExists(username)) {
            users.put(username, new User(username, password, email, country, role));
           
        }
    }

    public boolean userExists(String username) {
        return users.containsKey(username);
    }

    
 

    public User getUser(String username) {
        return users.get(username);
    }
    public boolean addUser(User user) {
        if (userExists(user.getUsername())) {
            return false;
        }
        users.put(user.getUsername(), user);
        return true;
    
        
        
    }
    
}
