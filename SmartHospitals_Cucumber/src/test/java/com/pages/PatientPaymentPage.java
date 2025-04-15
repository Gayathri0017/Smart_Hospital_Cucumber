package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PatientPaymentPage {
	
	@FindBy(xpath = "//div[@id='tabs']/div[1]/div[1]//following-sibling::div[1]/div/ul/li[10]//preceding-sibling::li[1]/a")
	public WebElement payment ;
	
	@FindBy(xpath = "//div[@id='payment']/div[1]/div/button")
	public WebElement makePayment ;
	
	@FindBy(xpath = "//form[@id='payment_form']/div[1]/div/label")
	public WebElement paymentText ;
	
	@FindBy(id = "amount_total_paid")
	public WebElement amount ;
	
	@FindBy(id = "pay_button")
	public WebElement addPaymentBtn ;
	
	@FindBy(id = "submit-button")
	public WebElement payNowBtn ;
	
	@FindBy(xpath ="//*[@id=\"Field-countryInput\"]")
	public WebElement country ;
	
	@FindBy(css ="#Field-numberInput")
	public WebElement cardNumber ;
	
	@FindBy(id = "Field-expiryInput")
	public WebElement cardExpiryNumber ;
	
	@FindBy(id = "Field-cvcInput")
	public WebElement cvvNumber ;
	
	@FindBy(xpath = "//*[@id=\"toast-container\"]/div/div")
	public WebElement invalidNumberTxt ;
	
	@FindBy(id = "Field-expiryError")
	public WebElement invalidCardDate ;
	
	@FindBy(id ="Field-cvcError")
	public WebElement invalidCvv ;
	
}
