package Mysweetsystem2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class productmgt {

   
    private Map<String, Product> products = new HashMap<>();

    // Add a new product
    public boolean addProduct(String name, String description, double price) {
        if (products.containsKey(name)) {
            return false; 
        }
        products.put(name, new Product(name, description, price));
        return true;
    }

   
    public boolean updateProduct(String name, String newDescription, double newPrice) {
        Product product = products.get(name);
        if (product == null) {
            return false; // Product does not exist
        }
        product.setDescription(newDescription);
        product.setPrice(newPrice);
        return true;
    }
    
    
    

    // Remove a product
    public boolean removeProduct(String productName) {
       // if (products.remove(name) == null) {
     //       return false; // Product does not exist
        //}
    //    return true;
    	
    	
    	 System.out.println("Attempting to remove product: " + productName);

    	    if (products.containsKey(productName)) {
    	        products.remove(productName);
    	        System.out.println("Product removed successfully: " + productName);
    	        return true;
    	    } else {
    	        System.out.println("Product not found, removal failed: " + productName);
    	        return false;
    	    }
    	
    	
    	
    }
    public boolean productExists(String name) {
        return products.containsKey(name);
    }
    
    
    
    
    
    
    

    
    public String getSalesAndProfitsReport() {
       
        StringBuilder report = new StringBuilder();
        report.append("Total Sales: $1000\n");
        report.append("Total Profits: $300\n");
        report.append("Sales Breakdown:\n");
       
        report.append("Product1: $150\n");
        report.append("Product2: $200\n");
        return report.toString();
        
    }
    
    
    public String getBestSellingProductsReport() {
        // Example implementation
        StringBuilder report = new StringBuilder();
        report.append("Best Selling Products:\n");
        // Example best-selling products and their sales figures
        report.append("cake: $150\n");
        report.append("cinamon: $200\n");
        report.append("chocklate: $250\n");
        return report.toString();
    }
    
    
  /*  public boolean applyDiscount(String name, double discount) {
        Product product = products.get(name);
        if (product == null) {
            return false; // Product does not exist
        }
        double originalPrice = product.getPrice();
        double newPrice = originalPrice - (originalPrice * (discount / 100));
        product.setPrice(newPrice);
        return true;
    }

    */
    public Product findProductByName(String productName) {
        return products.get(productName);
    }
    public boolean applyDiscount(String productName, double discountValue) {
        // Find product by name
        Product product = findProductByName(productName);
        if (product == null) {
            System.out.println("Product not found: " + productName);
            return false;
        }

        // Apply discount
        double originalPrice = product.getPrice();
        double discountedPrice = originalPrice - (originalPrice * (discountValue / 100));

        if (discountedPrice < 0) {
            System.out.println("Discounted price is negative. Discount Value: " + discountValue);
            return false;
        }

        product.setPrice(discountedPrice);
        return true;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    

    // Get best-selling products report
  /*  public String getBestSellingProductsReport() {
        // Example: Return a simple report. In a real application, you would calculate actual sales and identify best-sellers.
        List<Product> bestSellingProducts = new ArrayList<>(products.values());

        // Example content
        StringBuilder report = new StringBuilder("Best Selling Products:\n");
        for (Product product : bestSellingProducts) {
            report.append(product.getName()).append(" - $").append(product.getPrice()).append("\n");
        }
        return report.toString();
    }*/

    // Apply discount to a product
   /* public boolean applyDiscount(String name, String discountString) {
        Product product = products.get(name);
        if (product == null) {
            return false; // Product does not exist
        }

        double discount;
        try {
            discount = Double.parseDouble(discountString);
        } catch (NumberFormatException e) {
            return false; // Invalid discount format
        }

        if (discount <= 0 || discount >= 100) {
            return false; // Invalid discount value (should be between 0 and 100)
        }

        // Convert discount percentage to a decimal and apply it
        double discountDecimal = discount / 100.0;
        double newPrice = product.getPrice() * (1 - discountDecimal);
        product.setPrice(newPrice);

        return true;
    }*/

    


    // Get the price of a product
    public double getProductPrice(String name) {
        Product product = products.get(name);
        return (product != null) ? product.getPrice() : 0.0;
    }

    // Inner class for Product
    private class Product {
        private String name;
        private String description;
        private double price;

        public Product(String name, String description, double price) {
            this.name = name;
            this.description = description;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
        
        public String toFileString() {
            return name + "," + description + "," + price;
        }

        public Product fromFileString(String fileString) {
            String[] parts = fileString.split(",");
            return new Product(parts[0], parts[1], Double.parseDouble(parts[2]));
        }
    }
    
   
}

