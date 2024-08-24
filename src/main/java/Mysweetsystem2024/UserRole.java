package Mysweetsystem2024;

public enum UserRole {

	 ADMIN,
	    STORE_OWNER,
	    SUPPLIER,
	    REGULAR_USER;
	
	    public static UserRole fromString(String role) {
	        // Convert to uppercase to handle case insensitivity
	        String roleUpper = role.trim().toUpperCase();
	        
	        // Iterate through all possible roles
	        for (UserRole r : UserRole.values()) {
	            if (r.name().equals(roleUpper)) {
	                return r;
	            }
	        }
	        
	        // Throw an exception if no match is found
	        throw new IllegalArgumentException("No enum constant " + UserRole.class.getCanonicalName() + "." + role);
	    }
}
