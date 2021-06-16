Feature: Checking fluent wait in the page

  Scenario: Use FluentWait to get the text
    Given I am in HomePage
    When I click dynamic load
    And I click example2
    And I click start and fluently wait
    Then I should see "Hello World!" in the page