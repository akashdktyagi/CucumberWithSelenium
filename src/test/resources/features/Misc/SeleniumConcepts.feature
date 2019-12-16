Feature: Selenium Concepts

  Scenario: Action Operation for Drag and Drop Operation
    Given I Open Chrome Browser
    And I navigate to URL as "https://jqueryui.com/"
    And I Click on "Droppable" Link
    When I drag Source Section and drop it on Target Section
    
    @wip
  Scenario: Action Operation for Slide Operation
    Given I Open Chrome Browser
    And I navigate to URL as "https://jqueryui.com/"
    And I Click on "Slider" Link
    When I Slide slider from point 0 to point 300

    
    