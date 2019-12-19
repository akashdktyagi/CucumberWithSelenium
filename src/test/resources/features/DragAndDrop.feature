Feature: Selenium Concepts

  Scenario: Action Operation for Drag and Drop Operation
    Given I Open Chrome Browser
    And I navigate to URL as "https://jqueryui.com/"
    And I Click on "Droppable" Link
    When I drag Source Section and drop it on Target Section
    Then Drag and Drop operation is successfull
