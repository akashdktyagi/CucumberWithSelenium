Feature: Request Loan
  I want to test parabank Request loan functionality
	
  Scenario: Request Loan
		Given Login in to Parabank url as "http://parabank.parasoft.com/parabank/index.htm" username as "john" passowrd as "demo"
		When I click on "Request Loan"
		And I entered loan amount as "100000"
		And I entered down Payment as "1"
		And I select account "From account #:" in to account field
	   And I click on "Apply Now" button
	   Then  page title should come "ParaBank | Loan Request Processed"
	 
