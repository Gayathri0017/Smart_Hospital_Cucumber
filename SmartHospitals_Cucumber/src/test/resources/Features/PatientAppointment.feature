Feature: Booking appointment using patient Login

@BookingAppointment
Scenario: Appointment booking for patient
	Given the User is on the Login Page
  When the User clicks the User Login 
  And the User clicks the Sign In button
  Then the User is able to click the my appointment button
  And the User is able to see the add appointment option 
  And the User can fill the appointment form 
  And the User should save the form for appointment