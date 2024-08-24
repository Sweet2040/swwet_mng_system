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

	    public Order(String orderId, String status, String productName, String quantity, String customerName, String storeOwnerName) {
	        this.orderId = orderId;
	        this.status = status;
	        this.productName = productName;
	        this.quantity = quantity;
	        this.customerName = customerName;
	        this.storeOwnerName = storeOwnerName;
	        this.creationTime = LocalDateTime.now(); 
	    }

	    public LocalDateTime getCreationTime() {
			return creationTime;
		}

		public void setCreationTime(LocalDateTime creationTime) {
			this.creationTime = creationTime;
		}

		// Getters and setters
	    public Order(String details) {
            this.setDetails(details);
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

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
