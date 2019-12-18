
Feature: Selenium Concept

  Scenario: Action Operation for Drag and Drop Operation
    Given Open Chrome browser
    And Navigate to URL "https://jqueryui.com/"
    When Click on "Droppable" link
    And I Drag source section and drop it on Target Section
    Then Drag and Drop operation is successfull

  Scenario: Action Operation Slide Operation
    When Click on "Slider" link
    And Slide slider from point 0 to point 300
    Then Slide Operation Sucessfully