Feature: Post and Share

Scenario: User posts content with description and image
Given the user "nuha" is logged in
When the user posts content with description "Delicious chocolate cake" and image "cake.jpg"
Then the post should be successfully created
And the post description should be "Delicious chocolate cake"
And the post image should be "cake.jpg"


Scenario: User tries to post content without description
Given the user "shahd" is logged in
When the user posts content with description "" and image "cake.jpg"
Then the post should fail with an error message "Description cannot be empty"



Scenario: User tries to post content without an image
Given the user "hala" is logged in
When the user posts content with description "Delicious chocolate cake" and image ""
Then the post should fail with an error message "Image cannot be empty"


 Scenario: Check Post toString method
    Given the user "nuha" is logged in
    When the user posts content with description "Delicious chocolate cake" and image "cake.jpg"
    Then the post toString method should be correct

  Scenario: Check Post displayPostDetails method
    Given the user "nuha" is logged in
    When the user posts content with description "Delicious chocolate cake" and image "cake.jpg"
    Then the post displayPostDetails should be correct
    
    
    
    
    Scenario: Update post description
    Given the user "john" is logged in
    When the user posts content with description "Old description" and image "cake.jpg"
    And the user updates the post description to "New description"
    Then the post description should be "New description"

 
  Scenario: Update post image
    Given the user "john" is logged in
    When the user posts content with description "Delicious chocolate cake" and image "old_image.jpg"
    And the user updates the post image to "new_image.jpg"
    Then the post image should be "new_image.jpg" 
