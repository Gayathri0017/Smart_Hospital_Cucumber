Feature: Gowri_14APR2025_Accountant_Income_Functionalities
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
     When the user enters the following income details:
    |header					|name |amount |
    |Telephone Bill	|			|100.00 |
    |Telephone Bill	|hi		|-52  	|
    |								|			|				|
    And the user clicks the save button
   Then the user should see an error notification