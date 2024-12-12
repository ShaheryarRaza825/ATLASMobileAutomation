Feature: Login to Atlas App


 Scenario Outline: Login to Atlas App with manager


    Given user is present on splash screen page
    Then user clicks the login button button on splash screen
    Given user is present on login page
    And user enters email "<Email>"
    And  user enters password "<Password>"
    Then user clicks the login button
    Then user should be not be logged in successfully

   Examples:

   | Email                  | Password    |
   | Harryp@abyssmail.com   | Atlas@123  |


  Scenario Outline: Login to Atlas App with wrong user name & password

    Given user is present on login page
    And user enters email "<Email>"
    And  user enters password "<Password>"
    Then user clicks the login button
    Then user should be logged in successfully due to credentials

    Examples:

      | Email                  | Password    |
      | chrisg@yopmail.com     | Atlas@1234  |


  Scenario: Login to Atlas App
    Given user is present on login page
  And user enters value in email field
  And user enters value in password field
  Then user clicks the login button
  Then user should be logged in successfully

  Scenario Outline: Login to Atlas with invalid user



    Examples:
      |  |