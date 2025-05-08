package com.actions;

import com.pages.SocialMediaVerificationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SocialMediaVerificationAction {
    private WebDriver driver;
    private SocialMediaVerificationPage socialMediaPage;
    private String mainWindowHandle;

    public SocialMediaVerificationAction(WebDriver driver) {
        this.driver = driver;
        this.socialMediaPage = new SocialMediaVerificationPage(driver);
        this.mainWindowHandle = driver.getWindowHandle();
    }

    public int getSocialMediaLinkCount() {
        List<WebElement> links = socialMediaPage.socialMediaLinks;
        
        return links.size();
    }
    
    public void clickFacebookLink() {
        clickSocialMediaLink(socialMediaPage.facebookLink);
    }

    public void clickTwitterLink() {
        clickSocialMediaLink(socialMediaPage.twitterLink);
    }

    public void clickYouTubeLink() {
        clickSocialMediaLink(socialMediaPage.youtubeLink);
    }

    public void clickGmailLink() {
        clickSocialMediaLink(socialMediaPage.gmailLink);
    }

    public void clickLinkedInLink() {
        clickSocialMediaLink(socialMediaPage.linkedinLink);
    }

    public void clickInstagramLink() {
        clickSocialMediaLink(socialMediaPage.instagramLink);
    }

    public void clickPinterestLink() {
        clickSocialMediaLink(socialMediaPage.pinterestLink);
    }

    public void clickFrontPageLink() {
        clickSocialMediaLink(socialMediaPage.frontPageLink);
    }

    private void clickSocialMediaLink(WebElement link) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(link)).click();
    }

    public void switchToNewTab() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        tabs.remove(mainWindowHandle);
        driver.switchTo().window(tabs.get(0));
        
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"));
    }

    public String getCurrentTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(webDriver -> {
            String title = webDriver.getTitle();
            return !title.isEmpty() ? title : null;
        });

    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void closeCurrentTabAndSwitchBack() {
        driver.close();
        driver.switchTo().window(mainWindowHandle);
    }
}