Feature:
  Complete user onboarding

  Scenario: Login and Complete Onboarding
    Given user is present on splash screen page
    Then user clicks the login button button on splash screen
    Given user is present on login page
    And user enters value in email field
    And user enters value in password field
    Then user clicks the login button
    Then user should be logged in successfully
    Given user is present on onboarding landing page
    Then user should click the Continue button below
    Then user can skip uploading profile picture
    And user will be present on Profile tab
    Then user enters values for the fields on PersonalInformation tab
    And user clicks the continue button
    Then user enters values for the fields on CitizenshipInformation tab
    And user clicks the continue button
    Then user enters the values for the fields on HomeAddress tab
    And user clicks the continue button

