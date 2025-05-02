package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SocialMediaVerificationPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@href=\"https://www.facebook.com/login\"]")
    public WebElement facebookLink;

    @FindBy(xpath = "//a[contains(@href, 'twitter.com')]")
    public WebElement twitterLink;

    @FindBy(xpath = "//a[contains(@href, 'youtube.com')]")
    public WebElement youtubeLink;

    @FindBy(xpath = "//a[contains(@href, 'gmail.com')]")
    public WebElement gmailLink;

    @FindBy(xpath = "//a[contains(@href, 'linkedin.com')]")
    public WebElement linkedinLink;

    @FindBy(xpath = "//a[contains(@href, 'instagram.com')]")
    public WebElement instagramLink;

    @FindBy(xpath = "//a[contains(@href, 'pinterest.com')]")
    public WebElement pinterestLink;

    @FindBy(xpath = "//*[@href=\"https://demo.smart-hospital.in\"]")
    public WebElement frontPageLink;

    public SocialMediaVerificationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}