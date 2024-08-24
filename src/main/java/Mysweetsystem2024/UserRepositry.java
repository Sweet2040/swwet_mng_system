package Mysweetsystem2024;

import java.util.HashMap;
import java.util.Map;

public class UserRepositry {

	
	private Map<String, User> userDatabase = new HashMap<>();
    private Map<String, User> archivedUsers = new HashMap<>();

    public boolean addUser(User user) {
        if (!userDatabase.containsKey(user.getUsername())) {
            userDatabase.put(user.getUsername(), user);
            return true;
        }
        return false;
    }

    public User getUser(String username) {
        return userDatabase.get(username);
    }

    public boolean updateUser(User user) {
        if (userDatabase.containsKey(user.getUsername())) {
            userDatabase.put(user.getUsername(), user);
            return true;
        }
        return false;
    }

    public boolean deleteUser(String username) {
        if (userDatabase.containsKey(username)) {
            User user = userDatabase.remove(username);
            archivedUsers.put(username, user);
            return true;
        }
        return false;
    }

    public User getArchivedUser(String username) {
        return archivedUsers.get(username);
    }	
	
	
	
	
	
	
	
	
}
