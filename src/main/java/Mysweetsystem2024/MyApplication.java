package Mysweetsystem2024;


import java.io.*;

import java.util.HashMap;

import java.util.Map;

import javax.swing.*;





public class MyApplication {
    private Map<String, User> users;
    private LoginManager loginManager;

    
    
    
    
    /////may edit 
    private static final String POSTS_FILE = "dessert_creations.txt";
    
    
    ////
    private static final String DESSERT_CREATIONS_FILE = "dessert_creations.txt";
    private static final String IMAGES_DIR = "images/";
    
    private JTextArea descriptionTextArea;
    private JButton uploadImageButton;
    private File selectedImageFile;
    
    private String currentUser; 

    
    
    
    
    

    public MyApplication() {
        users = new HashMap<>();
        loginManager = new LoginManager(users);
       
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
