Feature: Entry Ad page - HTML alert testing


  @IH-8
  Scenario: HTML alert testing
    Given I am in HomePage
    When I click entryAd link
    Then I should land to entryAd page
    And close html alert should display
    When I click close
    Then html alert should disappeared
    When I double click clickHere
    Then html alert should display again