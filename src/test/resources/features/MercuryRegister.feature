@ignore
Feature: Registering new user

  @register
  Scenario: Registering new user with random data
    Given I am in mercury homepage
    When I click register
    And I provide account details
    When I click submit button in the register page
    Then I should be able to see confirmation message containing my email.