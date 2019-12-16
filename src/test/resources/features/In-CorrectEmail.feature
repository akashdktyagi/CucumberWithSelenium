Feature: Check error message
 @wip
Scenario: Negative Test: Enter In-correct email format in the User name Box and check error message
    Given I open "chrome" browser
    And I navigate to url as "http://demo.cs-cart.com/"
    When I click on "My Account" Menu link at top right corner of the page
    And I click on "Sign In" button
    And I remove previous email
    And I enter email address as "customer@1234.com"
    And I click on Sign In button on the pop up
    Then Application should throw error as "The email address in the E-mail field is invalid."