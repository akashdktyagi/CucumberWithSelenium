

Feature: Transfer Funds
	I want to transfer funds from one account to other account
	
	
  Scenario: Transfer Funds
		Given Login in to Parabank url as "http://parabank.parasoft.com/parabank/index.htm" username as "john" passowrd as "demo"
		When I click on "Transfer Funds"
		And I enter amount as "10" in amount field
		And I select account "12345" in from account field
		And I select account "12456" in to account field
		And I click on transfer funds button
		Then Verify  Amount "10" is transfered from account "12345" to account "12456" 
		
		
				
