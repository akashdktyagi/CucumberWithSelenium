Feature: i want to use action class for tool tip



Scenario Outline: Action Operation for Tool tip
    Given I Open Chrome Browser
    And I navigate to URL as "https://jqueryui.com/"
    And I Click on "Tooltip" Link
    When I hover on "<ToolTipName>" link
    Then Hover text appears with text as "<HoverTextToVerify>"
   Examples:
    |ToolTipName		|				HoverTextToVerify										|
    |Tooltips				|		That's what this widget is							|
    |ThemeRoller 		|		ThemeRoller: jQuery UI's theme builder application   |

