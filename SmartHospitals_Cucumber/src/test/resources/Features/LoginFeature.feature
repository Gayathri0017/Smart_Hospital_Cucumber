Feature: Gowri_09APR2025_Login_functionality_for_the Smart_Hospital_website

Background:
  Given the user is on the login page
  @ValidLoginCredentials
  Scenario Outline: Verify the Login with roles
    When the user selects the role "<role>"
    And the user clicks the Sign In button
    Then the user should see the dashboard page for the "<role>" role
    Examples:
      |role         |
      |Admin        |
      |Receptionist |
      |Nurse        |
      |Super Admin  |
      |Doctor       |
      |Accountant   |
      
   @InvalidUserName
  Scenario Outline: Attempt to login with missing username
   When the user selects the role "<role>"
    And User leaves the "username" field empty
     And the user clicks the Sign In button
    Then User should see an error message

    Examples:
      |role         |
      |Admin        |
      |Receptionist |
      |Nurse        |
      
	@InvalidPassword
  Scenario Outline: Attempt to login with missing password

    When the user selects the role "<role>"
    And User leaves the "password" field empty
     And the user clicks the Sign In button
    Then User should see an error message
    Examples:
      |role         |
      |Super Admin  |
      |Doctor       |
      |Pharmacist   |
     
      
	@InvalidUsername_And_Password
  Scenario Outline: Attempt to login with missing username and password
    When the user selects the role "<role>"
    And User leaves the "both" field empty
   And the user clicks the Sign In button
    Then User should see an error message
   Examples:
      |role         |
      |Pathologist  |
      |Radiologist  |
      |Accountant   |
