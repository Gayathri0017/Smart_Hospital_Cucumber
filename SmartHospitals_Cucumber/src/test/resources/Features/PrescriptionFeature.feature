Feature: Doctor add Prescription for the Feature in Smart Hospital
Background:
	Given Doctor is logged in to the Smart Hospital system
  @Add_Prescription_forPatient_with_validCredentials
  Scenario: verify the prescription feature by providing valid informations
    	When the Doctor Navigates to the OPD section
    	And Clicks the Add Prescription
    	Then the doctor should navigate to the Prescription Page
    	When the doctor Fill the valid Details:
    	|Finding Category| Medicine Category|Medicine|Dose Interval |Dose Duration|
    	|Syrup					 | Alprovit         |1  (CT) |Only one a day|Morning      |
    	And Clicks Save button
    	Then the Prescription should be added in OPD Section
