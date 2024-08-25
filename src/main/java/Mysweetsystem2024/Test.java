package Mysweetsystem2024;

import java.util.HashMap;
import java.util.Map;

public class Test {
	 private boolean adminLoggedIn = false;
	    private String currentSection = "";
	    private Map<String, String> reports = new HashMap<>();

	    public Test() {
	       
	        reports.put("Financial Report", "Total Profits: $10000\nDetailed Report: [Details here]");
	        reports.put("Best-Selling Products", "Store A: Product X - 500 units\nStore B: Product Y - 300 units");
	        reports.put("User Statistics", "Nablus: 200 users\nJenin: 150 users");
	    }

	    
	    public void loginAsAdmin() {
	       
	        adminLoggedIn = true;
	        System.out.println("Admin logged in.");
	    }

	    
	    public void navigateToSection(String section) {
	        if (adminLoggedIn) {
	            currentSection = section;
	            System.out.println("Navigated to: " + section);
	        } else {
	            throw new IllegalStateException("Admin not logged in. Please log in first.");
	        }
	    }

	   
	    public String requestFinancialReport() {
	        if ("Financial Reports".equals(currentSection)) {
	            return reports.get("Financial Report");
	        } else {
	            throw new IllegalStateException("Not in the Financial Reports section.");
	        }
	    }

	    
	    public String requestBestSellingProductsReport() {
	        if ("Store Reports".equals(currentSection)) {
	            return reports.get("Best-Selling Products");
	        } else {
	            throw new IllegalStateException("Not in the Store Reports section.");
	        }
	    }

	    
	    public String requestUserStatisticsByCity() {
	        if ("User Statistics".equals(currentSection)) {
	            return reports.get("User Statistics");
	        } else {
	            throw new IllegalStateException("Not in the User Statistics section.");
	        }
	    }
	}
	


