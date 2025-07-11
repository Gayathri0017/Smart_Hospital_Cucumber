Feature: Gowri_26MAY2025_TPA_Management

  Background: 
    Given Users launches the Smart Hospital application
    When the users selects role "Accountant"
     And the users clicks the Sign In buttons

    
  @ChargeDetails
  Scenario: Confirm the TPA Management
    Then Users should see the dashboard summary table
    And the Users Clicks the TPA Management button
    Then the users Should be able to see the Name of the TPA managers
    Then the user should need to print the name of the TPA Managers 