Feature: Login functionality

  Scenario: Login with valid credentials.
    Given User navigates to login page
    When User enters valid email address "amotooricap9@gmail.com" in the email field
    And User had entered a valid password "12345"
    And User clicks on Login button
    Then User should get successfully logged in

  Scenario: Login with invalid credentials.
    Given User navigates to login page
    When User enters invalid email address in the email fields
    And User had entered a invalid password "123456789"
    And User clicks on Login button
    Then User gets warning message for invalid credentials mismatch

  Scenario: Login with valid email and invalid password.
    Given User navigates to login page
    When User enters valid email address "amotooricap9@gmail.com" in the email field
    And User had entered a invalid password "123456789"
    And User clicks on Login button
    Then User gets warning message for invalid credentials mismatch

  Scenario: Login with invalid email and valid password.
    Given User navigates to login page
    When User enters invalid email address in the email fields
    And User had entered a valid password "12345"
    And User clicks on Login button
    Then User gets warning message for invalid credentials mismatch

  Scenario: Login without providing any credentials.
    Given User navigates to login page
    When User does not enter email address in the email field
    And User does not enter password in the password field
    And User clicks on Login button
    Then User gets warning message for invalid credentials mismatch