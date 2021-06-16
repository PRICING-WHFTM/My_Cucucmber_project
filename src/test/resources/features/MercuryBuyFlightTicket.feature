@ignore
Feature: Buy new Flight ticket

  @buyflight
  Scenario: Buying new Flight ticket step by step
    Given I am in mercury homepage
    And I logged in the account
    When I select trip type
    And I select passengers count
    And I select departing location
    And I select departing month and date
    And I select arriving location
    And I select returning month and date
    And I select service class
    And I select airline
    When I click continue button in the page
    Then I should see "DEPART" text in the page
    When I choose depart and return flight
    And I click continue button in select flight page
    Then I should be abe to see "Summary" test in the next page
    When I provide passengers details
      | firstname | lastname  |
      | Anar      | Salmanov  |
      | Nazakat   | Salmanova |
    And I choose meal for passenger1 as "Muslim" passenger2 as "Kosher"
    And I choose payment method as "MasterCard"
    And card number "0000111122223333" , expiration "09" , year "2010"
    And I provide address and click same as billing address
    When I click secure purchase
    Then I should get flight confirmation number
    And in departing I should see "New York to London"
    And in Returning I should see "London to New York"
    And total price including taxes should be "$1264 USD"
    When I click logout in flight confirmation page
    Then I should land to the signOn page






