Feature: JQueryUI elements

  @IH-15
  Scenario: JQueryUI elements
    Given I am in HomePage
    When I click jquery
    Then I should land to jquery age
    When I hover to enabled
    And I hover to downloads
    Then I should see 3 options there
    When I click "PDF" in options
    Then It should be downloaded to my computer