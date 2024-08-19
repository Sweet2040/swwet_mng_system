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

	    public Order(String orderId, String status, String productName, String quantity, String customerName, String storeOwnerName) {
	        this.orderId = orderId;
	        this.status = status;
	        this.productName = productName;
	        this.quantity = quantity;
	        this.customerName = customerName;
	        this.storeOwnerName = storeOwnerName;
	        this.creationTime = LocalDateTime.now(); 
	    }
	    public Order(String orderId, String details) {
	        this.orderId = orderId;
	        String[] parts = details.split(",");
	        if (parts.length == 5) {  // Ensure there are enough details provided
	            this.status = parts[0].trim();
	            this.productName = parts[1].trim();
	            this.quantity = parts[2].trim();
	            this.customerName = parts[3].trim();
	            this.storeOwnerName = parts[4].trim();
	        } else {
	            throw new IllegalArgumentException("Invalid details format. Expected 5 comma-separated values.");
	        }
	        this.creationTime = LocalDateTime.now(); // Set the creation time to the current time
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
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

