Feature: Accountant Dashboard Functionalities

  @ValidLoginCredentials
  Scenario: Add New Expense and Verify
    Given User launches the Smart Hospital application
    When the user selects role "Accountant"
    And the user clicks the Sign In buttons
    Then User should see the dashboard summary table
    And User should capture and print the data from dashboard table section "/html/body/div[1]/div[1]/section/div[2]" this should be stored in the excel for reference
    