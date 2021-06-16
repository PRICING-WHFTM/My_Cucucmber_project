Feature: Checking all 3 functions of JavaScript AlertHello

  Background:Hello

    Given I am in HomePage
    When I click javaScriptAlerts
    Then I should land to javaScript page

  Scenario: Accept
    When I click click for js alert
    And I accept the jsAlert
    Then I should see "You successfuly clicked an alert" message

  Scenario: Cancel
    When I click click for js confirm
    And I dismiss the jsAlert
    Then I should see "You clicked: Cancel" message2

@ignore
  Scenario: send text in JavaScript alert
    When I click click for js prompt
    And I send the text "Hello"
    Then I should see "You entered: Hello" message3