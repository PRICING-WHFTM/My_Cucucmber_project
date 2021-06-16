Feature: Add by increment and decrement

  Scenario: Adding by incrementing and decrementing
    Given I am in HomePage
    When I click inputs
    Then I should land to inputs page
    When I increment 5 times
    And Decrement 2 times
    Then I should see 3 in editbox