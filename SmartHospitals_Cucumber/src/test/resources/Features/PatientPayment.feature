Feature: Dhanush_13APR2025_Payment features with card details
  
  Background: 
    Given the User is on the Login Page
 		And the User clicks the User Login 
  	And the User clicks the Sign In button
  	When the User is directed to the patient dashboard
  	Then the User clicks Ipd button 
 		And the User clicks payment option
 		
 @WithoutCard
 Scenario: Payment by invalid card number

 	And the User doesnt provide the any card details
 	And the User can able to see the error message "Your card number is incomplete."
 
 @InvalidCardNumber
 Scenario Outline: Payment by invalid card number

 	And the User provide the card details
 	|Country				|CardNumber						|ExpiryDate					|CVV		|
 	|<Country>		  |<CardNumber>        	|<ExpiryDate> 			|<CVV> 	|
 	And the User clicks pay now button
 	And the User can able to see the error message "Your card number is incomplete."
 	
 	Examples:
 	|Country				|CardNumber						|ExpiryDate					|CVV		|
 	|Iceland				|4242424242424240			|05/31							|123		|
 	
 @InvalidExpiryDate
 Scenario Outline: Payment by invalid card expiry date

 	And the User provide the card details
 	|Country				|CardNumber						|ExpiryDate					|CVV		|
 	|<Country>		  |<CardNumber>        	|<ExpiryDate> 			|<CVV> 	|
 	And the User clicks pay now button
 	And the User can able to see the error message "Your card’s expiration year is in the past."
 	
 	Examples:
 	|Country				|CardNumber						|ExpiryDate					|CVV		|
 	|Iceland				|4242424242424242			|05/13							|123		|
 
 @InvalidCvvNumber
 Scenario Outline: Payment by invalid card cvv number

 	And the User provide the card details
 	|Country				|CardNumber						|ExpiryDate					|CVV		|
 	|<Country>		  |<CardNumber>        	|<ExpiryDate> 			|<CVV> 	|
 	And the User clicks pay now button
 	And the User can able to see the error message "Your card’s security code is incomplete."
 	Examples:
 	|Country				|CardNumber						|ExpiryDate					|CVV		|
 	|Iceland				|4242424242424242			|05/31							|12			|
 	|Iceland				|4242424242424242			|05/31							|45			|
 	
