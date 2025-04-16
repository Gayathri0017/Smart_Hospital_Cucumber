
package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PatientWorkflowPage {
	
	@FindBy(xpath="/html/body/div[1]/div/div/div/div[1]/div/div[2]/p[1]/a[1]")
	public WebElement userLoginBtn ;
	
	@FindBy(xpath="//button[@class='btn']")
	public WebElement signInBtn ;
	
	@FindBy(id = "email")
	public WebElement email ;
	
	@FindBy(id = "password")
	public WebElement password ;
	
	@FindBy(xpath = "//div[@class='form-bottom']/form/div[1]/span/p")
	public WebElement usernameReq ;
	
	@FindBy(xpath="//div[@class='form-bottom']/form/div[2]/span/p")
	public WebElement passwordReq ;
	
	
}
