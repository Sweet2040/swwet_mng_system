
package Mysweetsystem2024;

public class Post {
    private String description;
    private String image;
    private String status;
    private String username;

    // Constructor with username
    public Post(String username, String imagePath, String text) {
        this.username = username;
        this.image = imagePath;
        this.description = text;
        this.status = "active"; // Default status if needed
    }

   

    // Getters and Setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    // Display post details
    public String displayPostDetails() {
        return "Description: " + description + ", Image: " + image + ", Status: " + status;
    }

    @Override
    public String toString() {
        return "Post{" +
                "description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", status='" + status + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
