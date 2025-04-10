
package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PatientWorkflowPage {
	
	@FindBy(xpath="//div[@class='form-bottom']/p/a")
	public WebElement userLoginBtn ;
	
	@FindBy(xpath="//button[@class='btn']")
	public WebElement signInBtn ;
	
	@FindBy(xpath="//div[@class='navbar-custom-menu']/ul/li[4]/a/img")
	public WebElement profile ;
	
	@FindBy(xpath="//div[@class='navbar-custom-menu']/ul/li[4]/ul/li/div/div[1]//following-sibling::div/h5")
	public WebElement verifyProfile ;
	
	@FindBy(id = "email")
	public WebElement email ;
	
	@FindBy(id = "password")
	public WebElement password ;
	
	@FindBy(xpath = "//div[@class='form-bottom']/form/div[1]/span/p")
	public WebElement usernameReq ;
	
	@FindBy(xpath="//div[@class='form-bottom']/form/div[2]/span/p")
	public WebElement passwordReq ;
}
