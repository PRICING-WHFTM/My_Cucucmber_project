@emdil
Feature: Context menu checking

  @IH-4
  Scenario: Verify JS alert appears on page after making context click
    Given I am in HomePage
    And I should see ContextMenu module in Homepage
    When I click on contextMenu module
    Then I should land to contextmenu page
    And empty square should display in the page
    When I do rightclik on square
    Then JS Alert should popup
    When I dismiss the alert
    Then alert should disappear.


