Feature: Gowri_06MAY2025_Reports_view_verifications
Background:
    Given User launches Smart Hospital website
    When the user selects "Accountant" role
    And the user clicks the Sign In
@AllTransactionsReport
  Scenario: verifing the all transactions report
  	Then the user click the Report 
  	And click on the Finance
  	And need to select the All Transaction Report
  	Then the user need to select the drop down button then need to select the "Last Week"
  	And clicking the search
  	Then need to see the total amount as same as the in amount (we need to iterate from the table and need to sum the amount)