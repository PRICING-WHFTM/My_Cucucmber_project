@memezok
Feature: Checkboxes


  @IH-3
  Scenario: Verify count of Checkboxes and by default selected checkbox
    Given I am in Home page
    Then I should see CheckBoxes module in Homepage
    When I click on Checkbox module
    Then I should land to new page
    And I should see two Checkboxes in the page with name "checkbox 1" and "checkbox 2"
    And checkbox2 should be checked by default
    When I uncheck checkbox2 and check checkbox1
    Then checkbox1 should be checked and checkbox2 should be unchecked

