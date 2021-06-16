Feature: Disappearing elements


  @IH-5
  Scenario: Checking disappearing elements and verifying
    Given I am in HomePage
    And I should see "Disappearing Elements" module in homepage
    When I click disappearing elements module in homepage
    Then I should land to Disappearing Elements page
    When I click About element in the page
    And element should disappear
