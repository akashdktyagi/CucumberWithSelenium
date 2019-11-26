Feature: Applying for loan
  checking if the loan amount is denied

  @wip
  Scenario: Validate Login
    Given Browser is  invoked
    And navigate to URL "http://parabank.parasoft.com/parabank/index.htm"
    When I enter username as "john"
    And I enter password as "demo"
    And I click on submit button
    Then Page title should come "ParaBank | Accounts Overview"
    And I click on "Request Loan" 
    And I enter Loan Amount as "100000"
    And I enter Downpayment as "10"
    And I enter From account  as "14676" 
    Then I click on Appply Now "Button"
    Then Loan Request Processed page should Display
    Then Loan Status is denied "We cannot grant a loan in that amount with your available funds."

    
    