Feature:
  Login to Atlas App

  Scenario: Login to Atlas App
  Given user is present on "splash" page
  Then user clicks the "loginSplash" button
  Given user is present on "login" page
  And user enters value in "email" field
  And user enters value in "password" field
  Then user clicks the "login" button
  Then user should be "logged in" successfully
