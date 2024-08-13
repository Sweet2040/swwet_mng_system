package Mysweetsystem2024;


public class User {
    private String username;
    private String password;
    private UserRole role;
    private String email;
    private String country;
    private String phoneNumber;

    public User(String username, String password, String country, String email, UserRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.country = country;
    }

    public User(String username, String password, String role) {
		// TODO Auto-generated constructor stub
	}
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    
    
    
    
    
    
    
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

    @Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", role=" + role + ", email=" + email
				+ ", country=" + country + "]";
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
