package com.actions;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.pages.ManageOutPatientPage;
import com.utils.HelperClass;

public class ManageOutPatientActions {
ManageOutPatientPage mp=null;
public ManageOutPatientActions() {
	this.mp=new ManageOutPatientPage();
	PageFactory.initElements(HelperClass.getDriver(), mp);
}
public void clickOpd() {
	mp.opd.click();
}
public void search(String s) throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(mp.search));
	mp.search.sendKeys(s+Keys.ENTER);
	Thread.sleep(3000);
}
public void clickIpd() {
	WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(mp.ipd));
	mp.ipd.click();
}
public void sendBedDetails(String id, String num) throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
    Thread.sleep(3000);
    Select bed = new Select(mp.bedId);
    //bed.selectByVisibleText(id);
    bed.selectByIndex(1);
    try {
    WebElement bedDropdown=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='select2-bed_no-container']")));
    bedDropdown.click();
    }catch(StaleElementReferenceException e) {
    	System.out.println(e.getMessage());
    }
    WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class=\"select2-search__field\"])[4]")));
    searchInput.sendKeys(num);
    mp.move.click();
    wait.until(ExpectedConditions.alertIsPresent());
    HelperClass.getDriver().switchTo().alert().accept();
}
public void assertMove(String ex) throws InterruptedException{
	Thread.sleep(3000);
	WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
    WebElement act= wait.until(ExpectedConditions.visibilityOf(mp.text));
	Assert.assertEquals(ex,act);
}
}
