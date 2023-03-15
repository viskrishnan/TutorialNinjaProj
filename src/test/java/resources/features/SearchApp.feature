Feature: Search Functionality

  Scenario: User searches for a valid product.
    Given User opens the Application
    When User enters valid product "HP" into search box field
    And User clicks on Search button
    Then User should get valid product displayed in search results


  Scenario: User searches for invalid product.
    Given User opens the Application
    When User enters invalid product "Honda" into search box field
    Then User clicks on Search button
    Then User should get a message about no product listing

  Scenario: User searches without any product name.
    Given User opens the Application
    When User does not enter valid any product details into search box field
    And User clicks on Search button
    Then User should get a message about no product listing