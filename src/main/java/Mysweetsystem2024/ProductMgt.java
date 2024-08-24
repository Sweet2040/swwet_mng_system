package Mysweetsystem2024;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductMgt {

    private static final Logger LOGGER = Logger.getLogger(ProductMgt.class.getName());
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
        LOGGER.log(Level.INFO, "Attempting to remove product: {0}", productName);

        if (products.containsKey(productName)) {
            products.remove(productName);
            LOGGER.log(Level.INFO, "Product removed successfully: {0}", productName);
            return true;
        } else {
            LOGGER.log(Level.WARNING, "Product not found, removal failed: {0}", productName);
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

    public Product findProductByName(String productName) {
        return products.get(productName);
    }

    public boolean applyDiscount(String productName, double discountValue) {
        // Find product by name
        Product product = findProductByName(productName);
        if (product == null) {
            LOGGER.log(Level.WARNING, "Product not found: {0}", productName);
            return false;
        }

        double originalPrice = product.getPrice();
        double discountedPrice = originalPrice - (originalPrice * (discountValue / 100));

        if (discountedPrice < 0) {
            LOGGER.log(Level.WARNING, "Discounted price is negative. Discount Value: {0}", discountValue);
            return false;
        }

        product.setPrice(discountedPrice);
        return true;
    }

    public double getProductPrice(String name) {
        Product product = products.get(name);
        return (product != null) ? product.getPrice() : 0.0;
    }

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
