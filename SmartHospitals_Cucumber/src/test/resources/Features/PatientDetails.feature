Feature: Dhanush_29APR2025_Getting Patient details

Background:
	Given the User is on the Login Page
  When the User clicks the User Login 
  And the User clicks the Sign In button
  Then the User is able to click the my appointment button
  
  @GettingDetails
  Scenario: Getting the patient details
  And the User can see the details of patient