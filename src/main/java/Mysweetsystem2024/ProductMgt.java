package Mysweetsystem2024;

public class ProductMgt {

   
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
            
    
    
    


    public boolean removeProduct(String productName) {
    	System.out.println("Attempting to remove product: " + productName);
        
        if (!products.containsKey(productName)) {
        	  System.out.println("Product not found, removal failed: " + productName);
            return false;
        }
        
        products.remove(productName);
        System.out.println("Product not found, removal failed: " + productName);
        return true;
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

 
        double originalPrice = product.getPrice();
        double discountedPrice = originalPrice - (originalPrice * (discountValue / 100));

       
        return discountedPrice >= 0 && setProductPrice(product, discountedPrice);
    }
  private boolean setProductPrice(Product product, double price) {
	    product.setPrice(price);
	    return true;
	}

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

    

        public void setDescription(String description) {
            this.description = description;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
      
    
   
}

   
}

