Feature:
  Login to Atlas App

  Scenario: Login to Atlas App
  Given user is present on 'login' page
  And user enters value in 'email' field
  And user enters value in 'password' field
  When user clicks the 'login' button
  Then user should be logged in successfully