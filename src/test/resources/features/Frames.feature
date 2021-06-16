@IH-11
Feature: Checking frames , simple frame

  Background: Pre-conditions for both scenario
    Given I am in HomePage
    When I click frame
    Then I should see "Nested Frames" and "iFrame" the page

  @IH-11
  Scenario: Simple frame in the page
    When I click iFrame
    Then only 1 frame should exist in the page
    Then I should be able to switch to frame and get current text "Your content goes here."
    When I clear the existing text and write "Hello World"
    Then text should e changed to "Hello World"

  @IH-11
  Scenario: Nested frame
    When I click nested frames
    Then 2 nested frames should appear on the page
    And I should be able to switch to parent frame
    And I should be able to switch to middle frame
    Then I should be able to switch back to parent frame and back to main webpage




