Feature:
PTO Submission

  Scenario: Submit a PTO Request

    When user clicks the "request timeoff" button
    And user is present on "request timeoff" page
    And user selects option for "PTO"
    And user selects option for "FromDate"
    And user selects option for "ToDate"
    And user clicks the "add hours" button
    And user enters value in "hours" field
    And user clicks the "save" button
    And user enters value in "PTOcomments" field
    And user clicks the "submit" button
    Then PTO should be submitted successfully
