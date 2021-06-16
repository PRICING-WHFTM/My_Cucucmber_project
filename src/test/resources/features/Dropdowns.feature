Feature: Dropdowns verifying


  @IH-6
  Scenario: Verify Dropdowns and some operations
    Given I am in HomePage
    And  "Dropdown" module  should exist in homepage
    When I click dropdown
    Then I should land to dropdown page
    And  should exist 3 dropdowns
    And dropdowns should have name "Option 1" and "Option 2"
    When I select "Option 1"
    Then "Option 1" should be selectedDropdown


