Feature: Add Timesheet details

  Scenario: Edit timesheet for a particular day

    Given user is present on "dashboard" page
    Then user clicks the "timesheet tab" button
    And user is present on "timesheet" page
    Then user clicks the "timesheet arrow" button
    Then user clicks the "edit timesheet" button
    And user is present on "edit timesheet" page
    Then user selects option for start time
    Then user selects option for end time
    And user clicks the "update" button
    Then timesheet is submitted successfully
