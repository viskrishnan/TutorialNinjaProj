Feature: Registration Functionality

  Scenario: User account creation with mandatory fields
    Given User navigates to Register account page
    When User enters the below fields
      | firstName | Krishnan                         |
      | lastName  | Subramanian                      |
      | email     | krishnansubramanian009@gmail.com |
      | telephone | 93807014                         |
      | password  | 12345                            |
    And User clicks on Privacy policy
    And User clicks on Continue button
    Then User Account should be created successfully

  Scenario: User account creation with duplicate details
    Given User navigates to Register account page
    When User enters the below fields
      | firstName | Krishnan                         |
      | lastName  | Subramanian                      |
      | email     | krishnansubramanian007@gmail.com |
      | telephone | 93807014                         |
      | password  | 12345                            |
    And User selects Yes for Newsletter
    And User clicks on Privacy policy
    And User clicks on Continue button
    Then User Account should get error message with duplicate email


  Scenario: User account creation without any details filled
    Given User navigates to Register account page
    Then User does not enter any user details
    And User clicks on Continue button
    Then User should get proper warning message for all mandatory fields