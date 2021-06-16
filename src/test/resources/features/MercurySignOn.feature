@ignore
Feature: Mercury SignOn feature

  Scenario: Mercury SignOn
    Given I am in mercury homepage
    When I click signOn in the page
    And I provide correct credentials
    When I click submit button in the signon page
    Then I should see continue button present in the page