package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PatientPaymentPage {
	
	@FindBy(xpath = "(//ul[@class='nav nav-tabs navheader navlistscroll']//li//following-sibling::li[8]/a)[1]")
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
	
	@FindBy(xpath ="//select[@id='Field-countryInput']")
	public WebElement country ;
	
	@FindBy(css ="#Field-numberInput")
	public WebElement cardNumber ;
	
	@FindBy(id = "Field-expiryInput")
	public WebElement cardExpiryNumber ;
	
	@FindBy(id = "Field-cvcInput")
	public WebElement cvvNumber ;
	
	@FindBy(xpath = "//div[@id='toast-container']/div/div")
	public WebElement invalidTxt ;
	
	@FindBy(id = "Field-numberError")
	public WebElement invalidCardNumber ;
	
	@FindBy(id = "Field-expiryError")
	public WebElement invalidCardDate ;
	
	@FindBy(id ="Field-cvcError")
	public WebElement invalidCvv ;
	
	@FindBy(xpath = "//iframe[contains(@src,'stripe.com')]")
	public WebElement frame ;
	
	@FindBy(xpath = "//div[@class='row']/div")
	public WebElement paymentSuccess ;
}
