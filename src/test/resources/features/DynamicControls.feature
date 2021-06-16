Feature: Dynamic Control

  Background: Repeated actions for both scenarios
    Given I am in HomePage
    And "Dynamic Controls" module should exists in homepage
    When I click dynamic controls
    Then I should land t dynamic controls page

  @IH-7
  Scenario: Enable and Disable edit-box
    And editBox in the page should be disabled by default
    And "Enable" button should exist in the page
    When I click enable button
    Then editBox should be enabled
    And I should see "It's enabled!" text displayed
  @IH-7
  Scenario: Add and Remove elements dynamically
    And "A checkbox" should display in the page
    And "Remove" button should display in the page
    And I should be able to check the checkbox
    When I click remove button
    Then checkbox should not display in the page
    And  "It's gone" text should display in the page
    And remove button should not display in the page
