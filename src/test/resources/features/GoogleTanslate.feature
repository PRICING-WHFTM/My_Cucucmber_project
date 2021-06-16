Feature:  Translate Google

  Scenario: Verify correct translation
    Given I am in "https://www.google.com/search?q=translate&oq=tra&aqs=chrome.0.69i59j69i57j35i39j46j0j46j69i60l2.4440j0j9&sourceid=chrome&ie=UTF-8" page
    And I choose from language "English"
    When I am entering  "I love you"
    And To language is "Italian"
    Then I should see text "ti amo"

