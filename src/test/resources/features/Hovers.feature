Feature: Hover on elements

  @IH-12
  Scenario: Hover on elements and get values
    Given I am in HomePage
    When I click hovers
    Then I should land to hovers page
    When I hover to images
    Then I should be able to read the texts under the images
      | name: user1 |
      | name: user2 |
      | name: user3 |


