
Feature: Request Loan
	I want to Request for Loan 
	
  Scenario: Apply for Loan when DownPayment is less.(Negative Test Case)   
		Given Login in to Parabank url as "http://parabank.parasoft.com/parabank/index.htm" username as "john" passowrd as "demo"
		When I click on "Request Loan"
		And I enter Loan Amount as "10000000000"
		And I enter DownPayment Amount as "10"
		And I select Account as "12345"
		And I click on Apply Now button
    Then Page title should come "ParaBank | Loan Request"
    And Loan status is "Denied"
    And message should come as "We cannot grant a loan in that amount with your available funds."