package Mysweetsystem2024;



import java.util.HashMap;

import java.util.Map;





public class MyApplication {
    private Map<String, User> users;    
    

    
    
    
    
    

    public MyApplication() {
        users = new HashMap<>();
        
       
    }

   

    public boolean userExists(String username) {
        return users.containsKey(username);
    }

    
 

    public User getUser(String username) {
        return users.get(username);
    }
    public boolean addUser(User user) {
     
        users.put(user.getUsername(), user);
        return true;
    
        
        
    }
    
}
