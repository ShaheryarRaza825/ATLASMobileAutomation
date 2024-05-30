Feature:
 Clockin

  Scenario: Clock in on ATLAS

    Given user is present on dashboard page
    And user clicks the clockin button
    Then user should be clocked in successfully