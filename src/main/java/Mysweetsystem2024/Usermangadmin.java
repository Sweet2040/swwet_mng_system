/*package Mysweetsystem2024;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Usermangadmin {

    private MyApplication app;
    private List<User> userList; 
    private boolean loggedIn;

    public Usermangadmin(MyApplication app) {
        this.app = app;
        this.userList = new ArrayList<>();
        this.loggedIn = false;
    }

    public boolean login(String username, String password) {
        String storedUsername = "adminUsername"; 
        String storedPassword = "adminPassword"; 

        if (username.equals(storedUsername) && password.equals(storedPassword)) {
            this.loggedIn = true;
            return true;
        } else {
            this.loggedIn = false;
            return false;
        }
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void navigateTo(String page) {
        
        System.out.println("Navigating to " + page);
        
    }

    public String setUserDetails(User user) {
        if (!loggedIn) {
            return "Admin not logged in";
        }

       
        boolean userExists = false;
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getEmail().equals(user.getEmail())) {
                userList.set(i, user); 
                userExists = true;
                break;
            }
        }

        if (!userExists) {
            userList.add(user); // Add new user
        }

        // Save changes to the users.txt file
        return saveUserDetailsToFile(user);
    }

    private String saveUserDetailsToFile(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("user.dat.txt", true))) {
            writer.write(user.toString()); 
            writer.newLine();
            return "User details saved successfully";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error saving user details";
        }
    }

    public String createUser(User user) {
        if (!loggedIn) {
            return "Admin not logged in";
        }

        // Check if user already exists
        for (User u : userList) {
            if (u.getEmail().equals(user.getEmail())) {
                return "User already exists";
            }
        }

        userList.add(user);
        return saveUserDetailsToFile(user);
    }

    public String updateUser(User user) {
        if (!loggedIn) {
            return "Admin not logged in";
        }

        boolean userUpdated = false;
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getEmail().equals(user.getEmail())) {
                userList.set(i, user);
                userUpdated = true;
                break;
            }
        }

        if (!userUpdated) {
            return "User not found";
        }

        return saveUserDetailsToFile(user);
    }

    public String deleteUser(User user) {
        if (!loggedIn) {
            return "Admin not logged in";
        }

        boolean userRemoved = false;
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getEmail().equals(user.getEmail())) {
                userList.remove(i);
                userRemoved = true;
                break;
            }
        }

        if (!userRemoved) {
            return "User not found";
        }

        
        return archiveUserInFile(user);
    }

    private String archiveUserInFile(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("user_archive.dat.txt", true))) {
            writer.write(user.toString()); 
            writer.newLine();
            return "User archived successfully";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error archiving user";
        }
    }

    public String selectUser(String email) {
        for (User u : userList) {
            if (u.getEmail().equals(email)) {
                return u.toString();
            }
        }
        return null;
    }

    public void setSearchParameters(String searchParams) {
    
        System.out.println("Search parameters set to: " + searchParams);

    }

    public boolean isFilteredListRetrieved() {
        
        return true; 
    }

    public boolean isUserListDisplayed() {
      
        return true; 
    }

    public boolean isUserMarkedAsDeleted(User user) {
        
        return true; 
    }

    public boolean isUserArchived(User user) {
                return true; 
    }

    public boolean isArchivedUserDataRetrieved() {
        
        return true; 
    }

    public boolean isArchivedUserListDisplayed() {
     
        return true; 
    }

    

}
*/
