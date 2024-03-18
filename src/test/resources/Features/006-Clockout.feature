Feature:
  Clockout

  Scenario: Clock out on ATLAS

    Given user is present on 'dashboard' page
    And user clicks the 'clockout' button
    Then user should be "clocked out" successfully