package com.actions;
import java.time.Duration;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.pages.PrescriptionPage;
import com.utils.HelperClass;
public class PrescriptionActions{
public PrescriptionPage pp=null;
DoctorActions da=new DoctorActions();
private static final Logger log=LogManager.getLogger(PrescriptionActions.class);
public PrescriptionActions() {
	this.pp=new PrescriptionPage();
	PageFactory.initElements(HelperClass.getDriver(),pp);
}
WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
//Select catogory 
public void selectFindingCategory(String s) {
    wait.until(ExpectedConditions.elementToBeClickable(pp.medicineCat)).click();
    wait.until(ExpectedConditions.visibilityOf(pp.search)).sendKeys(s);
    pp.search.sendKeys("\n");
    log.info("Finding category selected={}", s);
}
public void selectMedicineCategory(String s) {
    wait.until(ExpectedConditions.elementToBeClickable(pp.medicineName)).click();
    wait.until(ExpectedConditions.visibilityOf(pp.search)).sendKeys(s);
    pp.search.sendKeys("\n");
    log.info("Medicine category selected={}",s);
}
public void selectMedicine(String s) {
    try {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(pp.dose));
        dropdown.click();
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOf(pp.search));
        searchBox.clear();
        searchBox.sendKeys(s);
        searchBox.sendKeys("\n");
        log.info("Medicine selected={}",s);
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}

public void selectDoseInterval(String s) {
    wait.until(ExpectedConditions.elementToBeClickable(pp.doseInterval)).click();
    wait.until(ExpectedConditions.visibilityOf(pp.search)).sendKeys(s);
    pp.search.sendKeys("\n");
    log.info("Dose interval selected={}",s);
}
public void selectDoseDuration(String s) {
    wait.until(ExpectedConditions.elementToBeClickable(pp.doseDuration)).click();
    wait.until(ExpectedConditions.visibilityOf(pp.search)).sendKeys(s);
    pp.search.sendKeys("\n");
    log.info("Dose duration selected={}",s);
}
public void OPDSection() {
	clickMethod(pp.opd);
	log.info("Navigated to OPD section");
}
public void addPres(){
	clickMethod(pp.addPrescription);
	log.info("Clicked Add Prescription");
}
public void assertPP(){
    wait.until(ExpectedConditions.visibilityOf(pp.text));
	String ex="Add Prescription";
	String act=pp.text.getText();
	Assert.assertEquals(ex, act);
}
public void save(){
	clickMethod(pp.save);
	log.info("Clicked Save");
}
public void edit() {
    wait.until(ExpectedConditions.visibilityOf(pp.edit));
	clickMethod(pp.edit);
}
WebDriverWait w= new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
JavascriptExecutor js=(JavascriptExecutor) HelperClass.getDriver();
public void assertinvalid(String ex) {
	try {
    wait.until(ExpectedConditions.visibilityOf(pp.errorMsg));
	String act=pp.errorMsg.getText();
	System.out.println("Expected: " + ex);
	System.out.println("Actual: " + act);
	Assert.assertTrue(act.contains(ex));
	}catch(Exception e) {
		System.out.println(e.getMessage());
		throw e;
	}
}
public void assertPrescription(String name){
    wait.until(ExpectedConditions.visibilityOf(pp.textPres));
	String act=pp.verifyView.getText();
	System.out.println("Expected: " + name);
	System.out.println("Actual: " + act);
	Assert.assertTrue(act.contains(name));
}
public void assertManual(){
    wait.until(ExpectedConditions.visibilityOf(pp.verifyManual));
	String act=pp.verifyManual.getText();
	String ex="Prescription";
	System.out.println("Expected: " + ex);
	System.out.println("Actual: " + act);
	Assert.assertTrue(act.contains(ex));
}
public void view(String patientName) {
    WebDriver driver = HelperClass.getDriver();
    List<WebElement> rows=driver.findElements(By.xpath("//table[@id='DataTables_Table_1']//tbody/tr"));
    for (WebElement row : rows) {
        WebElement name=row.findElement(By.xpath("./td[2]"));
        if (name.getText().contains(patientName)) {
            WebElement viewBtn=row.findElement(By.xpath("./td[9]/div/a[2]"));
            viewBtn.click();
            log.info("Clicked View for patient: {}",patientName);
            return;
        }
    }
    log.error("Patient name not found:{}",patientName);
}
public void assertShow(String ex) {
	wait.until(ExpectedConditions.visibilityOf(pp.showText));
	String act=pp.showText.getText();
	Assert.assertEquals(ex,act);
}
public void delete(){
	clickMethod(pp.delete);
	log.info("Clicked Delete");
}
public void editClick() {
	wait.until(ExpectedConditions.elementToBeClickable(pp.edit));
	clickMethod(pp.edit);
}
public void clickMethod(WebElement ele) {
    try {
        wait.until(ExpectedConditions.elementToBeClickable(ele));
        ele.click();
    } catch (ElementClickInterceptedException e) {
        js.executeScript("arguments[0].click();", ele);
    } catch (Exception e) {
        System.out.println("Click failed: " + e.getMessage());
    }
}
public void sendKeysMethod(WebElement ele, String text) {
    try {
        wait.until(ExpectedConditions.visibilityOf(ele));
        ele.sendKeys(text);
    } catch (Exception e) {
        System.out.println("SendKeys failed: " + e.getMessage());
    }
}
public void viewPres() {
	clickMethod(pp.manualP);
}
}
