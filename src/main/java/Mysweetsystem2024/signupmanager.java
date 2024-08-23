package Mysweetsystem2024;

import java.util.List;

public class signupmanager {
    private MyApplication app;
    public signupmanager(MyApplication app) {
        this.app = app;
    }
    public boolean signUp(String username, String password, String email, String country, UserRole role) {
        if (app.userExists(username)) {
            return false; 
        }

        User newUser = new User(username, password, email, country, role);
        app.addUser(newUser);
        return true; 
    }
    
    

       
      
    

    
}

