Feature: Checking Forgot password functionality with 3rd party Gmail email

  Scenario: Checking ForgotPassword functionality
    Given I am in HomePage
    When I click forgot password
    And I provide email "j2j11@gmail.com"
    Then I should see the message "Your e-mail's been sent!"


