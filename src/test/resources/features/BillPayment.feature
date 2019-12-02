
Feature: Bill Payment Feature
  I want to perform Bill Payment 

  @wip
  Scenario: Bill Payment
    Given Login in to Parabank url as "http://parabank.parasoft.com/parabank/index.htm" username as "john" passowrd as "demo"
		And I click on Bill Pay 
    And I Fill Payee Name as "Aakash"
    And I fill Address as "Pune"
    And I fill City as "Mumbai"
    And I fill State as "Maharashtra" 
    And I fill Zip Code as "411052"
    And I fill Phone as "123456"
    When I fill Account as "20115"
    And I fill Verify Account as "201155"
    And I fill Amount as "100"
    And I fill From account as "18894"
    And I click On Send Payment button
    Then successful bill payment message should come 

 