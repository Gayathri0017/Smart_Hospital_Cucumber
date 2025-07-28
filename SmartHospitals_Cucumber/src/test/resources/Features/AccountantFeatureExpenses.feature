Feature: Gowri_11APR2025_Accountant_Dashboard_Functionalities
Background: 
    Given User launches the Smart Hospital application
    When the user selects role "Accountant"
    And the user clicks the Sign In buttons
    Then User should see the dashboard summary table
    

@ValidInput
Scenario: Add New Expense and Verify
And User should capture and print the data from dashboard table section this should be stored in the excel for reference
    And then need enter to the Expenses
    Then need click Add Expenses
    Then need to give the Header as "Vehicle Stand Charges", name "Office Telephone Charges" and amount "100.00"
    And the user click the save
    Then need to see the asseart the success notifications
    Then User should see the dashboard summary table
    And User should capture and print the data from dashboard table section this should be stored in the excel for reference

@InvalidInput
Scenario Outline: Add New Expense with Invalid Data
    And then need enter to the Expenses
    Then need click Add Expenses
    Then need to give the Header as "<header>", name "<name>" and amount "<amount>"
    And the user click the save
    Then need to see the asseart the error notifications

    Examples:
      |header                 |name                     |amount       |
      |Vehicle Stand Charges  |Office Telephone Charges |-100.00      |
      |Vehicle Stand Charges  |hi                       |-52|