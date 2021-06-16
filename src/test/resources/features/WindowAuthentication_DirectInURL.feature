Feature: Basic Window Authentication popup handling


  @WindowAuthentication
  Scenario: Handling Window popup using direct username and password in url
      #http://username:password@siteUrl
    Given I enter "https://admin:admin@the-internet.herokuapp.com/basic_auth"
    Then I should see "Congratulations! You must have the proper credentials." message in the page

