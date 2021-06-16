Feature:  Shifting content

  Scenario: Shifting content example 1 elements
    Given I am in HomePage
    When I click shifting content
    Then I should see 3 examples
    When I click first example
    Then I should see 5 options
    |Home|
    |About|
    |Contact Us|
    |Portfolio|
    |Gallery  |
