Feature: Register New User
	This feature file contains test cases to register new Users


Scenario: Validate Register new User is working
    Given Browser is  invoked
		Given navigate to URL "http://parabank.parasoft.com/parabank/index.htm"
	  When I clicked  on Register
	  And  I fill first name as "Ramesh"
	  And  I fill last name as "Roshan"
	  And I fill Address as "USA"
    And I fill City as "dallas"
    And I fill State as "texas"
    And I fill Zip code as "4110987"
    And I fill Phone as "123456789"
    And I fill SSN as "xyz"
    And I fill username as "Ramesh" 
    And I fill password as "1234"
    And I fill confirm password as"1234"	  
	  And I click on Register Button
	  Then New user is able to login username as "Ramesh" and password as "1234" 
	  And New user is able to login successfully again after logout
	  