Feature: try to Create A new Board
  Scenario: create new Board and get ID
    Given set Request for craete Board
    When put specification for create Board
    Then Check response for create Board