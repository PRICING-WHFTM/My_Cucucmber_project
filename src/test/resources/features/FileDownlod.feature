Feature: Downloading multiple files


  Scenario: Downloading multiple file
    Given I am in HomePage
    When I click file download
    Then I should be able to see 25 elements in the page
    When I click "text.txt"
    Then file should be downloaded to my computer

