Feature: Map page details

  Scenario: Light side rooms should contain yale room
    Given User is in the login page
    When User logs in with username "ucharlot7y@nbcnews.com" and password "archibaldmelloy"
    Then User should be able to see "yale" room
    Then In DB I should see the "yale" room



