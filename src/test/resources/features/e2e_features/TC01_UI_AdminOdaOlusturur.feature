  @e2e
Feature: TC01 UI Creating a room on medunna

  Scenario Outline: TC01 Positive scenario
    Given the user navigates to the "baseUrl" website
    When the user clicks on the user icon
    And clicks on the sign in option
    And enters the username in the username field
    And enters the password in the password field
    And clicks on the sign in button
    And clicks on the Items and Titles option
    And clicks on the room option
    And click on the Create a new room button
    And enters a room number in the room number field
    And selects SUITE from the room type menu
    And clicks on the status checkbox
    And enters "<price>" in the Price field
    And enters a "<description>" in the Description field
    And clicks on the save button
    Then verify A new Room is created succesfully
    And closes the application
    Examples:
      | price    | description                          |
      | 123.00   | End To End Test icin olusturulmustur |

















