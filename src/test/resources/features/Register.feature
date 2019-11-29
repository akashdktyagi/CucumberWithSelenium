Feature: Parabank Register feature
  I want to test parabank Register functionality
  @wip
  Scenario: Validate Login
    Given Browser is  invoked
    
    And navigate to URL "http://parabank.parasoft.com/parabank/index.htm"
    When I click on "Register"
    And I entered First name as "rupali"	
    And I entered Last Name as "mishra"	
    And I entered Address as " shivajingr"	
And I entered City as "pune"
And I entered State as	"maharashtra"
And I entered Zip Code as "462198"
And I entered Phone# as "123456789"
And I entered SSN as "14325"
 
And I entered Username as "rup"	
And I entered Password as "123"	
And I entered Confirm as "123"
And I click  button "Register"
Then confirmation msg appeared as "Your account was created successfully. You are now logged in."
    
