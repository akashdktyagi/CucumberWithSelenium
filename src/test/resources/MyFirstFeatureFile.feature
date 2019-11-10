Feature: Parabank Login feature
  I want to test parabank login functionality

  @tag1
  Scenario: Validate Login
    Given Browser is  invoked
    And navigate to URL "http://parabank.parasoft.com/parabank/index.htm"
    When I enter username as "john"
    And I enter password as "demo"
    And I click on submit button
    Then I page title should come "ParaBank | Accounts Overview"

