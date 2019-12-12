Feature: User is able to login in to the application
@wip
Scenario: Check user is able to login in to the application
    Given I open "chrome" browser
    And I navigate to url as "http://demo.cs-cart.com/"
    When I click on "My Account" Menu link at top right corner of the page
    And I click on "Sign In" button
    And I click on Sign In button on the pop up
    Then User is signed in and "Sign out" button is displayed after clicking on "My Account" button
