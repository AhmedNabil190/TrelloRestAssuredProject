Feature: Get all Lists on Board
  Scenario: try to retrieve Lists
    Given Set Request for get Lists
    When put request specification for get Lists
    Then Check response for get Lists