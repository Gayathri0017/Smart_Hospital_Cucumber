Feature: Login with the Patient Login Credentials
  
  Background: 
    Given the User is on the Login Page
 		And the User clicks the User Login 
  	And the User clicks the Sign In button
  	When the User is directed to the patient dashboard
  	Then the User clicks Ipd button 
 		And the User clicks payment option
 		
 @PatientPayment
 
 Scenario: Payment by invalid card number

 	And the User doesnt provide the any card details
 	And the User can able to see the error message "Your card number is incomplete."
 
 Scenario: Payment by invalid card number

 	And the User provide the card details
 	|Country				|CardNumber						|ExpiryDate					|CVV		|
 	|Iceland				|4242424242424240			|5/31								|123		|
 	And the User can able to see the error message "Your card number is invalid."
 	
 Scenario: Payment by invalid card expiry date

 	And the User provide the card details
 	|Country				|CardNumber						|ExpiryDate					|CVV		|
 	|Iceland				|4242424242424242			|5/13								|123		|
 	And the User can able to see the error message "Your card’s expiration year is in the past."
 
 Scenario: Payment by Valid card details

 	And the User provide the card details
 	|Country				|CardNumber						|ExpiryDate					|CVV		|
 	|Iceland				|4242424242424242			|5/31								|123		|
 	And the User clicks pay now button
 	And the User can able to see the success message "Thank you for your payment"