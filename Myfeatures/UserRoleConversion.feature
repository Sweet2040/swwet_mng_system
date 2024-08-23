Feature: User Role Conversion
  As a system developer
  I want to convert user role strings to their corresponding enum values
  So that I can ensure proper role assignment and validation

  Scenario: Convert valid user role strings
    Given a user role string "ADMIN"
    When I convert the string to a UserRole
    Then the result should be "ADMIN"

  Scenario: Convert valid user role strings with different cases
    Given a user role string "store_owner"
    When I convert the string to a UserRole
    Then the result should be "STORE_OWNER"

  Scenario: Convert valid user role strings with extra spaces
    Given a user role string "  SUPPLIER  "
    When I convert the string to a UserRole
    Then the result should be "SUPPLIER"

  Scenario: Convert invalid user role string
    Given a user role string "INVALID_ROLE"
    When I convert the string to a UserRole
    Then an IllegalArgumentException should be thrown

  Scenario: Convert null user role string
    Given a null user role string
    When I convert the string to a UserRole
    Then a NullPointerException should be thrown
