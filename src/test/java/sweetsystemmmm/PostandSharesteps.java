/*
package sweetsystemmmm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Mysweetsystem2024.MyApplication;
import Mysweetsystem2024.Post;  // Import the Post class
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PostandSharesteps {

    MyApplication app;
    private String username;
    private Post post;  // Instance of Post class
    private boolean postSuccess;
    private String errorMessage;
    
    @Given("the user {string} is logged in")
    public void theUserIsLoggedIn(String username) {
        this.username = username;
    }

    @When("the user posts content with description {string} and image {string}")
    public void theUserPostsContentWithDescriptionAndImage(String description, String image) {
        if (description.isEmpty()) {
            postSuccess = false;
            errorMessage = "Description cannot be empty";
        } else if (image.isEmpty()) {
            postSuccess = false;
            errorMessage = "Image cannot be empty";
        } else {
            post = new Post(username, image, description);  // Create a new Post object
            postSuccess = true;
            errorMessage = null;
        }
    }

    @Then("the post should be successfully created")
    public void thePostShouldBeSuccessfullyCreated() {
        assertTrue("Post should be created successfully", postSuccess);
        assertTrue("Post object should not be null", post != null);
    }

    @Then("the post description should be {string}")
    public void thePostDescriptionShouldBe(String expectedDescription) {
        assertEquals("Post description should match", expectedDescription, post.getDescription());
    }

    @Then("the post image should be {string}")
    public void thePostImageShouldBe(String expectedImage) {
        assertEquals("Post image should match", expectedImage, post.getImage());
    }

    @Then("the post should fail with an error message {string}")
    public void thePostShouldFailWithAnErrorMessage(String expectedErrorMessage) {
        assertFalse("Post should not be created", postSuccess);
        assertEquals("Error message should match", expectedErrorMessage, errorMessage);
        assertTrue("Post object should be null", post == null);  // Ensure post is not created
    }
}



  */
package sweetsystemmmm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Mysweetsystem2024.MyApplication;
import Mysweetsystem2024.Post;

public class PostandSharesteps {

  /*  private String username;
    private Post post;  // Instance of Post class
    private boolean postSuccess;
    private String errorMessage;

    @Given("the user {string} is logged in")
    public void theUserIsLoggedIn(String username) {
        this.username = username;
    }

    @When("the user posts content with description {string} and image {string}")
    public void theUserPostsContentWithDescriptionAndImage(String description, String image) {
        if (description.isEmpty()) {
            postSuccess = false;
            errorMessage = "Description cannot be empty";
            post = null;
        } else if (image.isEmpty()) {
            postSuccess = false;
            errorMessage = "Image cannot be empty";
            post = null;
        } else {
            post = new Post(username, image, description);  // Create a new Post object
            postSuccess = true;
            errorMessage = null;
        }
    }

    @Then("the post should be successfully created")
    public void thePostShouldBeSuccessfullyCreated() {
        assertTrue("Post should be created successfully", postSuccess);
        assertTrue("Post object should not be null", post != null);
    }

    @Then("the post description should be {string}")
    public void thePostDescriptionShouldBe(String expectedDescription) {
        assertEquals("Post description should match", expectedDescription, post.getDescription());
    }

    @Then("the post image should be {string}")
    public void thePostImageShouldBe(String expectedImage) {
        assertEquals("Post image should match", expectedImage, post.getImage());
    }

    @Then("the post should fail with an error message {string}")
    public void thePostShouldFailWithAnErrorMessage(String expectedErrorMessage) {
        assertFalse("Post should not be created", postSuccess);
        assertEquals("Error message should match", expectedErrorMessage, errorMessage);
        assertTrue("Post object should be null", post == null);  // Ensure post is not created
        
        
        
    }
    
    */
	 private String username;
	    private Post post;  // Instance of Post class
	    private boolean postSuccess;
	    private String errorMessage;

	   private  MyApplication app;
	    public PostandSharesteps(MyApplication app) {
	    	this.app=app;
	    }
	    
	    
	    
	    
	    @Given("the user {string} is logged in")
	    public void theUserIsLoggedIn(String username) {
	        this.username = username;
	    }

	    @When("the user posts content with description {string} and image {string}")
	    public void theUserPostsContentWithDescriptionAndImage(String description, String image) {
	        if (description.isEmpty()) {
	            postSuccess = false;
	            errorMessage = "Description cannot be empty";
	            post = null;
	        } else if (image.isEmpty()) {
	            postSuccess = false;
	            errorMessage = "Image cannot be empty";
	            post = null;
	        } else {
	            post = new Post(username, image, description);  // Create a new Post object
	            postSuccess = true;
	            errorMessage = null;
	        }
	    }

	    @Then("the post should be successfully created")
	    public void thePostShouldBeSuccessfullyCreated() {
	        assertTrue("Post should be created successfully", postSuccess);
	        assertNotNull("Post object should not be null", post);
	    }

	    @Then("the post description should be {string}")
	    public void thePostDescriptionShouldBe(String expectedDescription) {
	        assertNotNull("Post object should not be null", post);
	        assertEquals("Post description should match", expectedDescription, post.getDescription());
	    }

	    @Then("the post image should be {string}")
	    public void thePostImageShouldBe(String expectedImage) {
	        assertNotNull("Post object should not be null", post);
	        assertEquals("Post image should match", expectedImage, post.getImage());
	    }

	    @Then("the post should fail with an error message {string}")
	    public void thePostShouldFailWithAnErrorMessage(String expectedErrorMessage) {
	        assertFalse("Post should not be created", postSuccess);
	        assertEquals("Error message should match", expectedErrorMessage, errorMessage);
	        assertNull("Post object should be null", post);  // Ensure post is not created
	    }

	    @Then("the post toString method should be correct")
	    public void thePostToStringMethodShouldBeCorrect() {
	        String expectedToString = "Post{" +
	                "description='" + post.getDescription() + '\'' +
	                ", image='" + post.getImage() + '\'' +
	                ", status='" + post.getStatus() + '\'' +
	                ", username='" + post.getUsername() + '\'' +
	                '}';
	        assertNotNull("Post object should not be null", post);
	        assertEquals("toString() should match expected string", expectedToString, post.toString());
	    }

	    @Then("the post displayPostDetails should be correct")
	    public void thePostDisplayPostDetailsShouldBeCorrect() {
	        String expectedDetails = "Description: " + post.getDescription() + 
	                                 ", Image: " + post.getImage() + 
	                                 ", Status: " + post.getStatus();
	        assertNotNull("Post object should not be null", post);
	        assertEquals("displayPostDetails() should match expected details", expectedDetails, post.displayPostDetails());
	    }
    
	    @When("the user updates the post description to {string}")
	    public void theUserUpdatesThePostDescriptionTo(String newDescription) {
	        if (post != null) {
	            post.setDescription(newDescription);
	        }
	    }

	    @When("the user updates the post image to {string}")
	    public void theUserUpdatesThePostImageTo(String newImage) {
	        if (post != null) {
	            post.setImage(newImage);
	        }
	    }
	    
	    
	    
	    
    
    
}


   

   

    

  


  
