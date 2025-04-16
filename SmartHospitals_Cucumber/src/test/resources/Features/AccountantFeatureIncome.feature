Feature: Accountant Income Functionalities

Background:
    Given User launches Smart Hospital website
    When the user selects "Accountant" role
    And the user clicks the Sign In
    Then the user navigates to the finance section and clicks on income
    And the user clicks on Add Income
    
  @ValidInput
  Scenario: Add New Income and Verify
    And the user enters the Header as "Hospital charge", name as "Dr.S.Ramkumar", and amount as "1500.00"
    And the user clicks the save button
    Then the user verifies that the new income is added to the table
    
  @InvalidInput
Scenario: Add New Income with Invalid Data
    And the user enters the Header as "Invalid Header", name as "Dr.s.Hari", and amount as "-100.00"
    And the user clicks the save button
    Then the user should see an error notification
    
  @InvalidWithoutAnyData
Scenario: Add New Income with No Data
    And the user clicks the save button
    Then the user should see an error notification