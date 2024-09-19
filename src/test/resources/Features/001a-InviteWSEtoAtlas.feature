Feature:
  Add a WSE and Invite to Atlas

  Scenario: Add and Invite WSE
    Given Admin is present on Atlas login page
    Then Admin enters value in email field on Atlas login page
    Then Admin enters value in password field on Atlas login page
    When Admin clicks the next button
    Then Admin should be logged in successfully to Atlas portal
    Given Admin is present on dashboard
    When Admin clicks the peoples tab
   Then Admin clicks the Add Employee button
    Then user should enter all details of WSE
    And user should click the Continue button
    Given user is present on Profile page
    Then user should click the Next button to move to Job Details page
    Then user should click the Next button to move to Documents page
    Then user should click the Next button to move to Pay Details page
    Then user should click the Next button to move to Time off page
    Then user should click the Next button to move to Invite WSE page
    Then user should click the Invite button to Invite the user to ATLAS
    And WSE should be invited successfully


