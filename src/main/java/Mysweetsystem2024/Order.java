package Mysweetsystem2024;

import java.time.LocalDateTime;

public class Order {

	private String orderId;
    private String status; // e.g., "Pending", "Processed", "Shipped", "Delivered"
    private String details; // Any additional information about the order
    private LocalDateTime creationTime;
    // Constructor
    public Order(String orderId, String status, String details) {
        this.orderId = orderId;
        this.status = status;
        this.details = details;
    }
    public Order(String orderId, String details) {
        this.orderId = orderId;
        this.details = details;
        this.status = "Pending";
    }
    public Order(String orderId, String status, LocalDateTime creationTime) {
        this.orderId = orderId;
        this.status = status;
        this.creationTime = creationTime;
    }
    // Getters and Setters
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", status='" + status + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }
	
    public boolean isNew() {
        // Define what "new" means: status is "new" or it was created in the last 24 hours
        boolean isNewStatus = "new".equalsIgnoreCase(status);
        boolean isCreatedRecently = creationTime.isAfter(LocalDateTime.now().minusHours(24)); // Example: created within the last 24 hours

        return isNewStatus || isCreatedRecently;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
