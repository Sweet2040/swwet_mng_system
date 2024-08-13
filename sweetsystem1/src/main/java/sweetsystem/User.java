package sweetsystem;

public class User {

    private String username;
    private String confirmationMessage;
    private boolean feedbackRecorded;

    public User(String username) {
        this.username = username;
    }

    // Method to send a message to the store owner
    public String sendMessageToStoreOwner(String subject, String message) {
        // Simulate sending a message (In reality, this would interact with a messaging system)
        confirmationMessage = "Message sent to store owner with subject: " + subject;
        return confirmationMessage;
    }

    // Method to submit feedback on a product
    public boolean submitProductFeedback(String rating, String comment) {
        // Simulate feedback submission (In reality, this would involve saving feedback in a database)
        feedbackRecorded = true; // Assuming feedback submission is successful
        return feedbackRecorded;
    }

    // Method to notify the store owner of the feedback
    public String notifyStoreOwner() {
        // Simulate notifying the store owner (In reality, this would send a notification)
        return "Store owner notified of feedback";
    }

    // Method to notify the recipe owner of the feedback
    public String notifyRecipeOwner() {
        // Simulate notifying the recipe owner (In reality, this would send a notification)
        return "Recipe owner notified of feedback";
    }

    // Getters and Setters for the private fields if needed
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getConfirmationMessage() {
        return confirmationMessage;
    }

    public boolean isFeedbackRecorded() {
        return feedbackRecorded;
    }
}


