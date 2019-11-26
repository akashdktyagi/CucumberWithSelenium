Feature: Parabank Login for Loan Request
  I want to test parabank Loan function
@wip
  Scenario: Validate Login
    Given Browser is  invoked
    And navigate to URL "http://parabank.parasoft.com/parabank/index.htm"
    When I enter username as "john"
    And I enter password as "demo"
    And I click on submit button
    Then Page title should come "ParaBank | Accounts Overview" 
    And I click on "Request Loan"
    And Page title should come "ParaBank | Request Loan"
    And I Enter loan amount as "10000"
    And I enter Down Payment as "10"
    Then I select From account as "15786"
    And click on Apply Now Button
    
    