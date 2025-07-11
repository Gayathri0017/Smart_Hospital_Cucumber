package com.actions;

import com.pages.AccountantPageIncome;
import com.utils.HelperClass;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AccountantActionsIncome {
    private WebDriver driver;
    private WebDriverWait wait;
    private AccountantPageIncome accountantPageIncome;
    private static final Logger log = LogManager.getLogger(AccountantActionsIncome.class);
//constructor 
    public AccountantActionsIncome() {
        this.driver = HelperClass.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.accountantPageIncome = new AccountantPageIncome(driver);
        log.info("Initialized AccountantActionsIncome");
    }

    public void selectRole(String role) {
        wait.until(ExpectedConditions.elementToBeClickable(accountantPageIncome.accountantRoleButton)).click();
        log.info("Selected role: %s" , role);
    }

    public void clickSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(accountantPageIncome.signInButton)).click();
        log.info("Clicked Sign In button");
    }

//    public void navigateToFinanceSection() {
//        wait.until(ExpectedConditions.elementToBeClickable(accountantPageIncome.financeSection)).click();
//        log.info("Navigated to Finance section");
//    }
    
//    public void navigateToFinanceSection() {
//        WebElement financeElement = wait.until(ExpectedConditions.visibilityOf(accountantPageIncome.financeSection));
//        wait.until(ExpectedConditions.elementToBeClickable(financeElement)).click();
//        log.info("Navigated to Finance section");
//    }
    
    public void listofamount() {
        wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(30));
        By locator = By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr/td[1]/a");

        List<WebElement> l1 = HelperClass.getDriver().findElements(locator);
        System.out.println("count:" + l1.size());
        for (int i = 0; i < l1.size(); i++) {
        	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            l1 = HelperClass.getDriver().findElements(locator); 
            WebElement list1 = l1.get(i);

            System.out.println(list1.getText());
        }
    }

    public void clickIncome() {
        wait.until(ExpectedConditions.elementToBeClickable(accountantPageIncome.incomeButton)).click();
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, 'admin/income')]")));

        log.info("Clicked Income button");
    }

    public void clickAddIncome() {
        wait.until(ExpectedConditions.elementToBeClickable(accountantPageIncome.addIncomeButton)).click();
        log.info("Clicked Add Income button");
    }

    public void enterIncomeDetails(String header, String name, String amount) {
        accountantPageIncome.incomeHeaderField.sendKeys(header);
        accountantPageIncome.incomeNameField.sendKeys(name);
        accountantPageIncome.incomeAmountField.sendKeys(amount);
        log.info("Entered income details - Header: {}, Name: {}, Amount: {}", header, name, amount);

    }

    public void clickSave() {
        accountantPageIncome.saveButton.click();
        log.info("Clicked Save button");
    }

    public void verifyIncomeAdded(String amount) {
    	int num=1;
    	WebDriverWait explicitWait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(30));


        
    	WebElement a=HelperClass.getDriver().findElement(By.xpath("//table[@class=\"table table-hover table-striped table-bordered ajaxlist dataTable no-footer\"]//tr["+num+"]//td[6]"));
        try {
            WebElement tableValueElement = explicitWait.until(ExpectedConditions.visibilityOf(a));
            String tableValueText = tableValueElement.getText();
            System.out.println(tableValueText);
            Assert.assertEquals(tableValueText, amount);

            log.info("Income amount verified successfully: %s" , amount);
        } catch (Exception e) {
            log.error("Error verifying income added", e);
            throw e;
        }
    }

    public boolean isErrorNotificationDisplayed() {
        try {
            boolean displayed = wait.until(ExpectedConditions.visibilityOf(accountantPageIncome.errorNotification)).isDisplayed();
            log.info("Error notification displayed: %s" , displayed);
            return displayed;
        } catch (Exception e) {
            log.error("Error notification not displayed", e);
            return false;
        }
    }

    public void Welcome() {
        log.info("Welcome method called");
        System.out.println("hi");
    }
}
