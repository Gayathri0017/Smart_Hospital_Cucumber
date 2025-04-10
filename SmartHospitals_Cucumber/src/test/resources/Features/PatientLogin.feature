Feature: Login with the Patient Login Credentials
  j
  
  @LoginIntoPatient
  Scenario: To check Login as patient 
  
  Given the User is on the Login Page
  When the User clicks the User Login 
  And the User clicks the Sign In button
  Then the User is directed to the patient dashboard
