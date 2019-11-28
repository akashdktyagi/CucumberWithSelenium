Feature: Parabank ForgotLoginInfo feature
  I want to test parabank ForgotloginInfo functionality
  @wip
  Scenario: Validate Login
    Given Browser is  invoked
    
    And navigate to URL "http://parabank.parasoft.com/parabank/index.htm"
    When I click on "Forgot login info?"
    And I entered first name as "john"	
    And I entered Last Name  "smith"	
    And I entered Address	"pimpri"
    And I entered City "pune"
    And I entered State	"MH"
    And I entered Zip Code	"462109"
    And I entered SSN  "14235"
    And I click "Find My Login Info"
    Then error msg should be appeared as "The customer information provided could not be found."
    