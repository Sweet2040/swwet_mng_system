package Mysweetsystem2024;

import java.time.LocalDateTime;

public class Order {
	
	    private String orderId;
	    private String status; 
	    private String productName;
	    private String quantity;
	    private String customerName;
	    private String storeOwnerName;
	    private LocalDateTime creationTime;
	    private String details;
	    private double price;
	    
	    public Order(String orderId, String details) {
	        String[] parts = details.split(",");
	        if (parts.length != 5) {
	            throw new IllegalArgumentException("Invalid details format. Expected 5 comma-separated values.");
	        }

	        this.productName = parts[0].trim();
	        this.quantity = parts[1].trim();  // Keep quantity as String
	        this.customerName = parts[2].trim();
	        this.storeOwnerName = parts[3].trim();
	        this.status = parts[4].trim();
	    }
	    public Order(String orderId, String status, String productName, String quantity, String customerName, String storeOwnerName) {
	        this.orderId = orderId;
	        this.status = status;
	        this.productName = productName;
	        this.quantity = quantity;
	        this.customerName = customerName;
	        this.storeOwnerName = storeOwnerName;
	        this.creationTime = LocalDateTime.now(); 
	    }

	    // Getters and setters
	    public Order(String details) {
            this.details = details;
            this.status = "Created";
        }
	    public String getOrderId() { return orderId; }
	    public String getStatus() { return status; }
	    public String getProductName() { return productName; }
	    public String getQuantity() { return quantity; }
	    public String getCustomerName() { return customerName; }
	    public String getStoreOwnerName() { return storeOwnerName; }

	    public void setOrderId(String orderId) { this.orderId = orderId; }
	    public void setStatus(String status) { this.status = status; }
	    public void setProductName(String productName) { this.productName = productName; }
	    public void setQuantity(String quantity) { this.quantity = quantity; }
	    public void setCustomerName(String customerName) { this.customerName = customerName; }
	    public void setStoreOwnerName(String storeOwnerName) { this.storeOwnerName = storeOwnerName; }
	



    // Other getters, setters, and methods...

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", status='" + status + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity='" + quantity + '\'' +
                ", customerName='" + customerName + '\'' +
                ", storeOwnerName='" + storeOwnerName + '\'' +
                '}';
    }
   
	
	public boolean isNew() {
        boolean isNewStatus = "new".equalsIgnoreCase(status);
        boolean isCreatedRecently = creationTime.isAfter(LocalDateTime.now().minusHours(24)); 
        return isNewStatus || isCreatedRecently;
    }
}
/*public class Order {
	
	    private String orderId;
	    private String status; 
	    private String productName;
	    private String quantity;
	    private String customerName;
	    private String storeOwnerName;
	    private LocalDateTime creationTime;
	   
	    
	   
	    private double price;
	    public Order(String orderId, String details) {
	        String[] parts = details.split(",");
	        if (parts.length != 5) {
	            throw new IllegalArgumentException("Invalid details format. Expected 5 comma-separated values.");
	        }

	        this.orderId = orderId;
	        this.productName = parts[0].trim();
	        this.quantity = Integer.parseInt(parts[1].trim());
	        this.price = Double.parseDouble(parts[2].trim());
	        this.status = parts[3].trim();
	    }
	    public Order(String orderId, String status, String productName, String quantity, String customerName, String storeOwnerName) {
	        this.orderId = orderId;
	        this.status = status;
	        this.productName = productName;
	        this.quantity = quantity;
	        this.customerName = customerName;
	        this.storeOwnerName = storeOwnerName;
	        this.creationTime = LocalDateTime.now(); 
	    }

	    // Getters and setters

	    public String getOrderId() { return orderId; }
	    public String getStatus() { return status; }
	    public String getProductName() { return productName; }
	    public String getQuantity() { return quantity; }
	    public String getCustomerName() { return customerName; }
	    public String getStoreOwnerName() { return storeOwnerName; }

	    public void setOrderId(String orderId) { this.orderId = orderId; }
	    public void setStatus(String status) { this.status = status; }
	    public void setProductName(String productName) { this.productName = productName; }
	    public void setQuantity(String quantity) { this.quantity = quantity; }
	    public void setCustomerName(String customerName) { this.customerName = customerName; }
	    public void setStoreOwnerName(String storeOwnerName) { this.storeOwnerName = storeOwnerName; }
	



    // Other getters, setters, and methods...

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", status='" + status + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity='" + quantity + '\'' +
                ", customerName='" + customerName + '\'' +
                ", storeOwnerName='" + storeOwnerName + '\'' +
                '}';
    }
   
	
	public boolean isNew() {
        boolean isNewStatus = "new".equalsIgnoreCase(status);
        boolean isCreatedRecently = creationTime.isAfter(LocalDateTime.now().minusHours(24)); 
        return isNewStatus || isCreatedRecently;
    }
}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

