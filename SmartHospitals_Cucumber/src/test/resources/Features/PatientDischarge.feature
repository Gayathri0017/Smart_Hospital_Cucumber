Feature: Discharging the patient

Background: 
	Given Doctor is logged in to the Smart Hospital system
	And the Doctor Navigates to the IPD section
	
	
@DischargingPatient

	Scenario: Doctor discharging without providing discharging date
	When the Doctor clicks the ipdNo
	And the Doctor clicks the discharge button
	Then the Doctor provides only discharge status "Normal"
	And the Doctor should save the Discharge status
	And the Doctor able to see the error "Discharge Date field is required"
	
	Scenario: Doctor discharging without providing discharging status
	When the Doctor clicks the ipdNo
	And the Doctor clicks the discharge button
	Then the Doctor provides only discharge date
	And the Doctor should save the Discharge status
	And the Doctor able to see the error "Discharge Status field is required"
	
	Scenario: Doctor discharging the patient by case ID
	When the Doctor provides the case Id in search field
	|caseID		|
<<<<<<< HEAD
	|6291			|
=======
	|6914			|
>>>>>>> branch 'main' of https://github.com/Gayathri0017/Smart_Hospital_Cucumber.git
	Then the Doctor provides the discharge details
	|DischargeStatus	| 
	|Normal						|
	And the Doctor should save the Discharge status