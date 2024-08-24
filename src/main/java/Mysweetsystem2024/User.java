
package Mysweetsystem2024;

public class User {
    private String username;
    private String password;
    private UserRole role;
    private String email;
    private String country;
    
    
   
    private boolean feedbackRecorded;
    public User(String username) {
        this.username = username;
    }
    public String sendMessageToStoreOwner(String subject,String message) {
      
        return   "Message sent to store owner with subject: " + subject;
    }
    public User(String username, String password, String email, String country, UserRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.country = country;
        
    }
  
    public boolean submitProductFeedback(String rating, String comment) {
        
        feedbackRecorded = true; 
        return feedbackRecorded;
    }
    public String notifyStoreOwner() {
       
        return "Store owner notified of feedback";
    }
    public String notifyRecipeOwner() {
       
        return "Recipe owner notified of feedback";
    }

     public User(String username, String password,  String role) {
        this.username = username;
        this.password = password;
        this.role = UserRole.valueOf(role.toUpperCase()); // Convert role string to UserRole enum
    }
   
    
    
    
    
    
	public User(String username2, String email2) {
		this.username=username2;
		this.email=email2;
	}

	public User(String username, String email, String password, String role1) {
		 this.username = username;
	        this.password = password;
	        this.role = role;
	        this.email = email;
	}

	// Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   

	public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public String toFileString() {
        return username + "," + password + "," + country + "," + email + "," + role;
    }

   
    
    
    
}
