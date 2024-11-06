Feature: More Tab Functionality

  Scenario: Navigate to My Account Profile
    When user navigates to More Tab
    Given user is present on More Tab
    Then user clicks the My Account option
    Given user is present on My Account page
    Then user clicks the Profile option
    Given user is present on My Account Profile page

  Scenario: Edit Contact Details
    Then user clicks the Contact Details tab
    Then user clicks the edit icon to edit contact details
    Then user updates the contact details
    When user saves the details updated contact details should be displayed

  Scenario: Edit Social Media Details
    Then user clicks the Social Media Details tab
    Then user clicks the edit icon to edit linkedin details
    Then user updates the linkedin details
    When user saves the details updated linkedin details should be displayed
    Then user clicks the edit icon to edit website details
    Then user updates the website details
    When user saves the details updated website details should be displayed
    Then user goes back to My Account page


  Scenario: Emergency Contact Details
    Given user is present on My Account page
    Then user clicks the Emergency Contact options
    Given user is present on My Account Emergency page
    Then user clicks the edit icon to edit emergency details
    Then user updates the emergency details
    When user saves the details updated emergency details should be displayed
