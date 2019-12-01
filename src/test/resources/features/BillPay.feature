Feature: Bill Payment
  Feature to test bil payment
  @wip
  Scenario: Pay Bill 
		Given Login in to Parabank url as "http://parabank.parasoft.com/parabank/index.htm" username as "john" passowrd as "demo"
		When I click on "Bill Pay"
		And I fill Bill payment form with data as
		|name   | Akash |
		|Address| xyz|
		|city   |pune|
		|state  |MH|
		|zipCode|12313|
		|phone  |5645646|
		|Account|20115|
		|verifyAccount|20115|
		|Ammount|20|
		|FromAccount|18894|
		
