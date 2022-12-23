Feature: try to Create A new Workspace
  Scenario: create new workspace and get ID
    Given set Request for craete organization
    When put specification for create organization
    Then Check response for create organization