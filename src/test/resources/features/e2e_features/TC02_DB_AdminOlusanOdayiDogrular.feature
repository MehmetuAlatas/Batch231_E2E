
@e2e
  Feature: TC02 DataBase Room Validation
    Scenario: Testing the room via DB
      Given Admin connect to the DataBase
      When send query for created room
      Then validates created room from resultset





