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
    Given user is present on WSE Personal Information page


