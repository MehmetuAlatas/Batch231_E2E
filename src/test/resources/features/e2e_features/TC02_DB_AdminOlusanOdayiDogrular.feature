
@e2e
  Feature: TC02 Database Room Validation
    Scenario: Testing the room via DB
      Given Admin Connect to the Database
      When send query for created room
      Then validates created room from resultset

