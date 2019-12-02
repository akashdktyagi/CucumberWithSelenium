Feature: Bill payment
  I want to use bill payment option 

  @wip
  Scenario: bill payment 
    Given Login in to Parabank url as "http://parabank.parasoft.com/parabank/index.htm" username as "john" passowrd as "demo"
    And I click on Bill Pay 
    And  I fill name as "rakesh"
    And  I fill address as "xyz"
    And I fill city as "puna" 
    And I fill state as "MH"
    And I fill zip code as "ABCDEF"
    And I fill phone as "123456789"
    When I fill account no. "13344"
    And I vetify account no. "13344"
    And I entere ammount "1000"
    And form account no. "13344"
    And  I click on Send Payment
    Then result should come Bill payment successful

  