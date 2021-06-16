@IH-01
Feature:Adding and removing elements to HerokuApp

  @IH-01
  Scenario:Add Remove module should display in HomePage
    Given User navigates to homepage
    Then  Add/Remove Elements should display in homePage

  @IH-01
  Scenario:Initially, 1 button Add element  button should display in in Add Remove Elements module
    Given I am in HomePage
    When  I click on Add/Remove Elements module
    Then  I should land to Add/Remove Elements page
    And   Only Add Elements button should display at the pagee

  @IH-01
  Scenario:After clicking Add elements button , then Delete Elements button should display
    Given I am in HomePage
    When  I click on Add/Remove Elements module
    Then  I should land to Add/Remove Elements page
    When  I click Add/Elements button
    Then  Delete Elements button is displaying


  @IH-01
  Scenario: User clicks Delete element button , then the element should disappear.
    Given I am in HomePage
    When  I click on Add/Remove Elements module
    Then  I should land to Add/Remove Elements page
    When  I click Add/Elements button
    Then  Delete Elements button is displaying
    When  I click to Delete Elements
    Then  The element is disappearing