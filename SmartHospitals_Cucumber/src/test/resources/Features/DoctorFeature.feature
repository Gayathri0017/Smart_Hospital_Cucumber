Feature: Manage Appointments in Smart Hospital
Background:
    Given Doctor is logged in to the Smart Hospital system
    Given the User navigate to the appointment section
    When Doctor clicks the Add Appointment button
    And Doctor clicks on New Patient button
    
    
  Scenario: Doctor creates a new appointment for a new patient
    And Doctor fills in patient details
    And Doctor clicks the save button
    Then Patient should be added successfully
    When Doctor fills in appointment details
    And Doctor clicks on save button
    Then Appointment should be created successfully
    
 Scenario: Doctor tries to create an appointment with an expired time slot
  And Doctor fills in patient details
  And Doctor clicks the save button
  Then Patient should be added successfully
  When Doctor fills Expired time for appointment
  Then Appointment creation should fail with "Appointment Time Is Expired" message
  
 Scenario: Doctor tries to add a new patient without entering the name
  And Doctor leaves the Name field empty in patient details
  And Doctor clicks the save button
  Then Patient creation should fail with "Name field is required" message
  
 Scenario: Doctor tries to add a new patient without entering the year
  And Doctor leaves the Year field empty in patient details
  And Doctor clicks the save button
  Then Patient creation should fail and show "Year field is required" message
  
 Scenario: Doctor tries to add a new patient without entering the Month
  And Doctor leaves the Month field empty in patient details
  And Doctor clicks the save button
  Then Patient creation should fail and shows "Month field is required" message 
  
 Scenario: Doctor tries to add a new patient without entering the day
  And Doctor leaves the Day field empty in patient details
  And Doctor clicks the save button
  Then Patient creation should fails and shows "Day field is required" message  
  
  


