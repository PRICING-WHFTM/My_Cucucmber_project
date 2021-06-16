Feature: Uploading file


  Scenario: Uploading file testing
    Given I am in HomePage
    When I click file upload
    And choose the file "text.txt"
    And click upload button
    Then I should get "File Uploaded!" confirmation text

