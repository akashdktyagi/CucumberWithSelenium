Feature: Login Feature


  Scenario: Check User email is already present in the login pop up
    Given I open "chrome" browser
    And I navigate to url as "http://demo.cs-cart.com/"
    When I enter text in search text box as "computer"
    And I click on Search button
    Then Search results are displayed
    