Feature: Login to Atlas App
  Scenario: Login to Atlas App

  Given user is present on splash screen page
  Then user clicks the login button button on splash screen
  Given user is present on login page
  And user enters value in email field
  And user enters value in password field
  Then user clicks the login button
  Then user should be logged in successfully
