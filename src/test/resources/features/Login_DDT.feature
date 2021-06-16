Feature: Login Data Driven
  Testing login function with different set of data

  #scenario outline  and examples table is used only if the whole test
  # will be repeated multiple times.

  @smoke
  Scenario Outline: Login negative test with different set of data
    Given Navigate to website
    When I enter "<username>" and "<password>"
    Then I should get the "<textMessage>"
    Examples:
      | username | password             | textMessage                    |
      | tomsmith | SuperSecretPassword! | You logged into a secure area! |
      | xosemi   | passcode             | Your username is invalid!      |
      | amador   | password             | Your username is invalid!      |
