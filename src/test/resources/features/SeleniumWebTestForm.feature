@webForm
Feature: Test Selenium Web Form

  Scenario Outline: Test Selenium Web form
    Given User navigates to Selenium Web form
    When user inputs "<input>" to Text input
    And user inputs password "<password>"
    And user adds "<comment>" to Textarea
    And user selects "<dropDownOption>" from select menu
    And user select "<city>" city
    And user verifies "<prePopulated>" is visible
    And user selects checkbox "<checkBoxOption>"
    And user clicks "<radioButton>" radio button
    And user chooses "<date>" as date
    And user moves slider to "<range>"
    Then user clicks the submit button
    And user verifies form is submitted

    Examples:
      | input | password | comment | dropDownOption | city | prePopulated | checkBoxOption | radioButton | date | range |
      | Hello World | Password112 | New Comment | One | San Francisco | Readonly input | 1 | 2 | 08-23-2020 | 20 |