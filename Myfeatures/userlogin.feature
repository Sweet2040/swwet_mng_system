Feature: Login Sweet Management System

  Scenario: user login
    Given that the user "nuha" is not logged in
    When user tries to login
    And password is "111111"
    Then user login succeeds

  Scenario: user cannot login
    Given that the user "nuha" is not logged in
    When user tries to login
    And password is "wrongpassword"
    Then user login fails

  Scenario: admin can login
    Given that the admin "shahd" is not logged in
    When admin tries to login
    And password is "222222"
    Then admin login succeeds

  Scenario: admin cannot login
    Given that the admin "shahd" is not logged in
    When admin tries to login
    And password is "wrongpassword"
    Then admin login fails

  Scenario: owner can login
    Given that the owner "hala" is not logged in
    When owner tries to login
    And password is "333333"
    Then owner login succeeds

  Scenario: owner cannot login
    Given that the owner "hala" is not logged in
    When owner tries to login
    And password is "wrongpassword"
    Then owner login fails

  Scenario: supplier can login
    Given that the supplier "safa" is not logged in
    When supplier tries to login
    And password is "444444"
    Then supplier login succeeds

  Scenario: supplier cannot login
    Given that the supplier "safa" is not logged in
    When supplier tries to login
    And password is "wrongpassword"
    Then supplier login fails
