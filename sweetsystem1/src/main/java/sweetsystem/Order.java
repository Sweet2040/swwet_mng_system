package sweetsystem;

public class Order {
	   private String orderId;
	    private String details;
	    private String status;

	    public Order(String orderId, String details) {
	        this.orderId = orderId;
	        this.details = details;
	        this.status = "Pending";
	    }

	    public String getOrderId() {
	        return orderId;
	    }

	    public String getDetails() {
	        return details;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }
}
