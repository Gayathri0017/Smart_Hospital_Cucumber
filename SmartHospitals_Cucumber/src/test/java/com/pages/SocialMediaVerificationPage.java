package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SocialMediaVerificationPage {
    private WebDriver driver;

    @FindBy(xpath = "(//ul[@class=\"social\"])[1]//child::li[1]")
    public WebElement facebookLink;

    @FindBy(xpath = "//a[contains(@href, 'twitter.com')]")
    public WebElement twitterLink;

    @FindBy(xpath = "//a[contains(@href, 'youtube.com')]")
    public WebElement youtubeLink;

    @FindBy(xpath = "(//*[@href=\"https://plus.google.com/people\"])[1]")
    public WebElement gmailLink;

    @FindBy(xpath = "//a[contains(@href, 'linkedin.com')]")
    public WebElement linkedinLink;

    @FindBy(xpath = "//a[contains(@href, 'instagram.com')]")
    public WebElement instagramLink;

    @FindBy(xpath = "//a[contains(@href, 'pinterest.com')]")
    public WebElement pinterestLink;

    @FindBy(xpath = "//*[@href=\"https://demo.smart-hospital.in\"]")
    public WebElement frontPageLink;
    
    @FindBy(xpath = "(//*[@class=\"social\"])[1]//child::li")
    public List<WebElement> socialMediaLinks;

    public SocialMediaVerificationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}