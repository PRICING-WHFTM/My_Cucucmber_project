Feature: Drag and Drop the element

  Scenario: Drag and Drop
    Given I am in HomePage
    Then I should see "Drag and Drop" module in the homepage
    When I click drag and drop
    Then I should land drag and drop page
    And I should see A and B elements
    Then I should be able to drag element A and drop to element B


