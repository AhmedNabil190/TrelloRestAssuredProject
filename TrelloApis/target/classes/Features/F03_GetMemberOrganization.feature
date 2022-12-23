Feature: Get all workspaces on the account
  Scenario: try to retrieve workspaces
    Given Set Request for get organizations
    When put request specification for get organizations
    Then Check response for get organizations