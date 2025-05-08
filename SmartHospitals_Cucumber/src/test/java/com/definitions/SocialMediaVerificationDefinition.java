package com.definitions;

import com.actions.SocialMediaVerificationAction;
import com.utils.HelperClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SocialMediaVerificationDefinition {
    private WebDriver driver = HelperClass.getDriver();
    private SocialMediaVerificationAction actions = new SocialMediaVerificationAction(driver);

    @Given("the user is on the application homepage")
    public void the_user_is_on_the_application_homepage() {
        driver.get("https://demo.smart-hospital.in/");
        driver.manage().window().maximize();
    }
    @When("the user checks all social media icons in the header")
    public void user_checks_all_social_media_icons_in_header() {
        actions.getSocialMediaLinkCount();
    }

    @Then("the user should see {int} social media links available")
    public void user_should_see_social_media_links_available(int expectedCount) {
        Assert.assertEquals(expectedCount, actions.getSocialMediaLinkCount());
    }

    @When("the user click on the {string} link")
    public void the_user_clicks_on_the_link(String linkName) {
        switch (linkName.toLowerCase()) {
            case "facebook":
                actions.clickFacebookLink();
                break;
            case "twitter":
                actions.clickTwitterLink();
                break;
            case "youtube":
                actions.clickYouTubeLink();
                break;
            case "linkedin":
                actions.clickLinkedInLink();
                break;
            case "instagram":
                actions.clickInstagramLink();
                break;
            case "pinterest":
                actions.clickPinterestLink();
                break;
            case "front page":
                actions.clickFrontPageLink();
                break;
            case "gmail":
            	actions.clickGmailLink();
            	break;
            default:
                throw new IllegalArgumentException("Unknown link: " + linkName);
        }
        if (!linkName.equalsIgnoreCase("front page")) {
            actions.switchToNewTab();
        }
    }

    @Then("the user should see the correct Facebook page title")
    public void the_user_should_see_the_correct_facebook_page_title() {
        try {
            String actualTitle = actions.getCurrentTitle();
            String currentUrl = actions.getCurrentUrl();
            
            System.out.println("Current URL: " + currentUrl);
            System.out.println("Actual Title: " + actualTitle);
            
            Assert.assertTrue(actualTitle.toLowerCase().contains("facebook"), 
                "Expected title to contain 'Facebook'. Actual title: " + actualTitle);
        } finally {
            actions.closeCurrentTabAndSwitchBack();
        }
    }

    @Then("the user should see the correct Twitter page title")
    public void the_user_should_see_the_correct_twitter_page_title() {
        try {
            String actualTitle = actions.getCurrentTitle();
            String currentUrl = actions.getCurrentUrl();
            
            System.out.println("Current URL: " + currentUrl);
            System.out.println("Actual Title: " + actualTitle);
            
            Assert.assertTrue(actualTitle.equalsIgnoreCase("X") || 
                            currentUrl.contains("twitter.com") || 
                            currentUrl.contains("x.com"),
                "Expected title to be 'X' or URL to contain 'twitter.com/x.com'. Actual title: " + actualTitle);
        } finally {
            actions.closeCurrentTabAndSwitchBack();
        }
    }

    @Then("the user should see the correct YouTube page title")
    public void the_user_should_see_the_correct_youtube_page_title() {
        try {
            String actualTitle = actions.getCurrentTitle();
            String currentUrl = actions.getCurrentUrl();
            
            System.out.println("Current URL: " + currentUrl);
            System.out.println("Actual Title: " + actualTitle);
            
            Assert.assertTrue(actualTitle.toLowerCase().contains("youtube"), 
                "Expected title to contain 'YouTube'. Actual title: " + actualTitle);
        } finally {
            actions.closeCurrentTabAndSwitchBack();
        }
    }

    @Then("the user should see the correct Gmail page title")
    public void the_user_should_see_the_correct_gmail_page_title() {
        try {
            String actualTitle = actions.getCurrentTitle();
            String currentUrl = actions.getCurrentUrl();
            System.out.println("Current URL: " + currentUrl);
            System.out.println("Actual Title: " + actualTitle);
            Assert.assertTrue(
                currentUrl.contains("googleblog.com") || 
                currentUrl.contains("mail.google.com") || 
                currentUrl.contains("accounts.google.com"),
                "Expected Gmail, Google sign-in, or Google Blog page. Actual URL: " + currentUrl
            );
        } finally {
            actions.closeCurrentTabAndSwitchBack();
        }
    }

    @Then("the user should see the correct LinkedIn page title")
    public void the_user_should_see_the_correct_linkedin_page_title() {
        try {
            String actualTitle = actions.getCurrentTitle();
            String currentUrl = actions.getCurrentUrl();
            
            System.out.println("Current URL: " + currentUrl);
            System.out.println("Actual Title: " + actualTitle);
            
            Assert.assertTrue(actualTitle.toLowerCase().contains("linkedin"), 
                "Expected title to contain 'LinkedIn'. Actual title: " + actualTitle);
        } finally {
            actions.closeCurrentTabAndSwitchBack();
        }
    }

    @Then("the user should see the correct Instagram page title")
    public void the_user_should_see_the_correct_instagram_page_title() {
        try {
            String actualTitle = actions.getCurrentTitle();
            String currentUrl = actions.getCurrentUrl();
            
            System.out.println("Current URL: " + currentUrl);
            System.out.println("Actual Title: " + actualTitle);
            
            Assert.assertTrue(actualTitle.toLowerCase().contains("instagram"), 
                "Expected title to contain 'Instagram'. Actual title: " + actualTitle);
        } finally {
            actions.closeCurrentTabAndSwitchBack();
        }
    }

    @Then("the user should see the correct Pinterest page title")
    public void the_user_should_see_the_correct_pinterest_page_title() {
        try {
            String actualTitle = actions.getCurrentTitle();
            String currentUrl = actions.getCurrentUrl();
            
            System.out.println("Current URL: " + currentUrl);
            System.out.println("Actual Title: " + actualTitle);
            
            Assert.assertTrue(actualTitle.toLowerCase().contains("pinterest"), 
                "Expected title to contain 'Pinterest'. Actual title: " + actualTitle);
        } finally {
            actions.closeCurrentTabAndSwitchBack();
        }
    }

    @Then("the user should see the correct front page title")
    public void the_user_should_see_the_correct_front_page_title() {
        String actualTitle = actions.getCurrentTitle();
        String currentUrl = actions.getCurrentUrl();
        
        System.out.println("Current URL: " + currentUrl);
        System.out.println("Actual Title: " + actualTitle);
        
        Assert.assertTrue(actualTitle.toLowerCase().contains("smart hospital"), 
            "Expected title to contain 'Smart Hospital'. Actual title: " + actualTitle);
    }
}