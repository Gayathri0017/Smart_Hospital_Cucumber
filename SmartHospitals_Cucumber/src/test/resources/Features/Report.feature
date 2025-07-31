Feature: Gowri_28July2025_Download_report

Background: 
    Given User launches the Smart Hospital application for report feature
    When the user selects role "Accountant" for report feature
    And the user clicks the Sign In buttons for report feature
    Then User should see the dashboard summary table for report feature


  @valid_All_Finance_Reports_view
  Scenario Outline: View Report for Finance 
  When the user clicks the Report menu
  And the user navigates to the Finance group
  And the user clicks on the Reports
  When the user selects the time duration "<duration>"
  And the user clicks the Search button
  Then the user should see the total amount 
  
  Examples:
  |duration      |
  |Today         |
  |This Week     |
  |Last Week     |
  |This Month    |
  |Last Month    |
  |Last 3 Months |
  |Last 6 Months |
  |Last 12 Months|
  |This Year     |
  |Last Year     |
  |Period        |  
  
@invalid_Finance_Report_NoDuration
Scenario: Attempt to view Finance Report without selecting a time duration
  When the user clicks the Report menu
  And the user navigates to the Finance group
  And the user clicks on the Reports
  And the user clicks the Search button
  Then the user should see the "Time Duration field is required"
  