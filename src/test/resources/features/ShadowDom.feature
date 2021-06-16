Feature: Accessing Shadow dom

  @shadow
  Scenario: Getting text from Shadow DOM
    Given I am in HomePage
    When I click shadow dom
    Then I should see "Let's have some different text!" in landed page