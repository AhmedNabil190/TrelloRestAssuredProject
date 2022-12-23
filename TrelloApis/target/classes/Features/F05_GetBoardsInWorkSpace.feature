Feature: Get all Boards on workspace
  Scenario: try to retrieve boards
    Given Set Request for get Boards
    When put request specification for get Boards
    Then Check response for get Boards