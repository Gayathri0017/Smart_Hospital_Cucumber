Feature: Login with the Patient Login Credentials
  
  Background: 
    Given the User is on the Login Page
 		And the User clicks the User Login 
  	And the User clicks the Sign In button
  	When the User is directed to the patient dashboard
  	
 @PatientPayment
 Scenario: Payment by invalid card number
 	Then the User clicks Ipd button 
 	And the User clicks payment option
 	And the User provide the invalid card details
 	|Country				|CardNumber						|ExpiryDate					|CVV		|
 	|India					|452145214512					|12/26							|123		|
 	And the User can able to see the error message "Your card number is invalid."