package Mysweetsystem2024;
import java.util.HashMap;
import java.util.Map;

import java.util.logging.Logger;
import java.util.logging.Level;
public class Test {


	private static final String USER_STATISTICS_REPORT = "User Statistics";
	
         private static final Logger logger = Logger.getLogger(Test.class.getName()); 

	
	 private boolean adminLoggedIn = false;
	    private String currentSection = "";
	    private Map<String, String> reports = new HashMap<>();

	    public Test() {
	       
	        reports.put("Financial Report", "Total Profits: $10000\nDetailed Report: [Details here]");
	        reports.put("Best-Selling Products", "Store A: Product X - 500 units\nStore B: Product Y - 300 units");
	        reports.put(USER_STATISTICS_REPORT, "Nablus: 200 users\nJenin: 150 users");
	    }
            public void loginAsAdmin() {
               adminLoggedIn = true;
               logger.log(Level.INFO, "Admin logged in."); // Replace System.out.println with logger
           }
	    

                public void navigateToSection(String section) {
        if (adminLoggedIn) {
            currentSection = section;
            logger.log(Level.INFO, "Navigated to: {0}", section); // Replace System.out.println with logger
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
	        if (USER_STATISTICS_REPORT.equals(currentSection)) {
	            return reports.get(USER_STATISTICS_REPORT);
	        } else {
	            throw new IllegalStateException("Not in the User Statistics section.");
	        }
	   }
	}
	
	
	

	
