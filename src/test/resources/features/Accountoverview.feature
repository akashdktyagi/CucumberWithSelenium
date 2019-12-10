

  Feature: Account Overview
	This feature file contains test cases related to account overview page of parabank


Scenario: Check account overview page table total amount displayed of sum of all the accounts
		Given Login in to Parabank url as "http://parabank.parasoft.com/parabank/index.htm" username as "john" passowrd as "demo"
	  When I clicked on "Account Overview"
	  And Account Overview page is displayed
	  Then Sum of all the accounts is equal to total amount displayed at the bottom of the table as "Total"


 
