Feature: Login Feature

  @wip
  Scenario: Check User email is already present in the login pop up
    Given I open "chrome" browser
    And I navigate to url as "http://demo.cs-cart.com/"
    When I click on "My Account" Menu link at top right corner of the page
    And I click on "Sign In" button
    Then Email is already displayed as "customer@example.com"
