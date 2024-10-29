Feature: Expense Requestor
  Scenario: Submit an expense claim

    Given user is present on dashboard page
    Then user clicks the "expenses tab" button
    And user is present on "expense dashboard" page
    Then user clicks the "new expense claim" button
    And user is present on "claim summary" page
    Then user enters value in "expense title" field
    Then user clicks the "save continue" button
    And user is present on "expenses" page
    Then user selects option for "date incurred"
    And user selects option for "category"
    And user enters value in "amount" field
    And user enters value in "VAT" field
    And user selects option for "attachment"
    And user enters value in "Exp comments" field
    Then user clicks the "submit expense" button
    And Expense should be submitted


