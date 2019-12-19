Feature: DragAndDrop Operation

Scenario: Test DragAndDrop functionality

        Given Browser is  invoked
        And I navigate to URL "https://jqueryui.com/"
        And I click on "Droppable" link, drag and drop elements should be displayed
        When I drag Source element and drop it over the Target element
        Then DragAndDrop operation should be successful and "dropped!" message should be desplayed.
        