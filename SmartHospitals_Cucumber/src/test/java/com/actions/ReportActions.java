package com.actions;

import com.pages.ReportPage;
import com.utils.HelperClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReportActions {

    private final WebDriver driver = HelperClass.getDriver();
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    private final ReportPage page  = new ReportPage(driver);

    /* =========  Navigation helpers ========= */

    private void openReportsMenu() {
//        WebElement arrow = wait.until(ExpectedConditions.elementToBeClickable(page.reportsRootLink));
//
//        // If the arrow's parent <li> does NOT already have 'active' or 'menu-open', click it
//        String classes = arrow.findElement(By.xpath("./..")).getAttribute("class");
//        if (classes == null || (!classes.contains("active") && !classes.contains("menu-open"))) {
//            arrow.click();
//            // Wait until the nested UL becomes visible
//            wait.until(ExpectedConditions.visibilityOfElementLocated(
//                    By.xpath("//span[text()='Reports']/ancestor::li[contains(@class,'treeview')]//ul[contains(@class,'treeview-menu')]")));
//        }
    		wait.until(ExpectedConditions.elementToBeClickable(page.reportsRootLink)).click();
    	
    }

    public void clickReportMenu() {
        
    	WebElement reportsLink = driver.findElement(By.xpath("//a[normalize-space()='Setup']"));
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", reportsLink);
    	openReportsMenu();
    }

    public void clickFinanceGroup() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(page.financeLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link);
        link.click();
    }

    public void clickAllTransactionReport() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(page.allTransactionReportLink));
        link.click();
    }

    public void selectDateRange(String visibleText) {
        Select drop = new Select(wait.until(ExpectedConditions.visibilityOf(page.timeDuration)));
        drop.selectByVisibleText(visibleText);
    }

    public void clickSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(page.searchBtn)).click();
    }

    public void getTotalTable() {
        wait.until(ExpectedConditions.visibilityOf(page.tablelist));
    }
}