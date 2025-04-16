package com.actions;
import java.io.File;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.pages.DoctorWorkflowPage;
import com.utils.ExcelReader;
import com.utils.HelperClass;
public class DoctorActions {
    DoctorWorkflowPage dp=null;
    ExcelReader reader=new ExcelReader("src\\test\\resources\\Book2.xlsx");
    private static final Logger log=LogManager.getLogger(DoctorActions.class);
    public DoctorActions() {
        this.dp=new DoctorWorkflowPage();
        PageFactory.initElements(HelperClass.getDriver(), dp);
    }
    public void login() {
        WebDriverWait wait=new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
        log.info("Clicking on Doctor and Sign In buttons");
        wait.until(ExpectedConditions.elementToBeClickable(dp.doctor)).click();
        wait.until(ExpectedConditions.elementToBeClickable(dp.signin)).click();
    }
    public void english() {
        WebDriverWait wait=new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
        log.info("Switching language to English");
        wait.until(ExpectedConditions.elementToBeClickable(dp.lan)).click();
        wait.until(ExpectedConditions.elementToBeClickable(dp.eng)).click();
    }
    public void appointment() {
        clickMethod(dp.appointment);
        log.info("Navigated to Appointment section");
    }
    public void addAppointment() {
        clickMethod(dp.addAppointment);
        log.info("Clicked on Add Appointment");
    }
    public void addPatient() {
        clickMethod(dp.addpatient);
        log.info("Clicked on Add Patient");
    }
    public void addPatientDetails() {
        addPatientDetailsFromRow(0, true);
    }
    public void addPatientDetailsFromRow(int rowIndex, boolean uploadPhoto) {
        log.info("Filling patient details from Excel row: {}", rowIndex);
        String name=reader.getCellData("Sheet1", rowIndex, 0);
        String gender=reader.getCellData("Sheet1", rowIndex, 1);
        String year=reader.getCellData("Sheet1", rowIndex, 2);
        String month=reader.getCellData("Sheet1", rowIndex, 3);
        String day=reader.getCellData("Sheet1", rowIndex, 4);
        sendKeysMethod(dp.pName, name);
        Select gen=new Select(dp.gender);
        gen.selectByVisibleText(gender);
        sendKeysMethod(dp.year, year);
        sendKeysMethod(dp.month, month);
        sendKeysMethod(dp.day, day);
        if (uploadPhoto) {
            String bloodgrp=reader.getCellData("Sheet1", rowIndex, 6);
            Select bg=new Select(dp.bloodGroup);
            bg.selectByVisibleText(bloodgrp);
            File file=new File("src\\test\\resources\\patient.jpg");
            dp.uploadPhoto.sendKeys(file.getAbsolutePath());
            log.info("Uploaded photo and selected blood group");
        }
    }
    public void save() {
        clickMethod(dp.saveBtn);
        log.info("Clicked Save Patient button");
    }
    public void assertPatient() throws InterruptedException {
        String name=reader.getCellData("Sheet1", 0, 0);
        String actual=dp.nameAfterAdd.getText();
        Thread.sleep(3000);
        log.info("Verifying added patient name");
        Assert.assertTrue(actual.contains(name));
    }
    public void addAppointmentDetails() {
        log.info("Filling appointment details from Excel");
        String shift=reader.getCellData("Sheet1", 0, 8);
        String slot=reader.getCellData("Sheet1", 0, 10);
        String status=reader.getCellData("Sheet1", 0, 11);
        String dis=reader.getCellData("Sheet1", 0, 12);
        new Select(dp.doc).selectByIndex(1);
        new Select(dp.shift).selectByVisibleText(shift);
        dp.date.click();
        dp.date.sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
        sendKeysMethod(dp.date, "03/10/2026  16:26:00");
        dp.date.sendKeys(Keys.ENTER);
        try {
            WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
            WebElement slotDd = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("slot")));
            new Select(slotDd).selectByVisibleText(slot);
        } catch (StaleElementReferenceException e) {
        }
        new Select(dp.status).selectByVisibleText(status);
        sendKeysMethod(dp.discount, dis);
        log.info("Appointment details filled with discount");
    }
    public void addAppointmentDetails1() {
        log.info("Filling appointment details from Excel");
        String shift=reader.getCellData("Sheet1", 1, 8);
        String slot=reader.getCellData("Sheet1", 1, 10);
        new Select(dp.doc).selectByIndex(1);
        new Select(dp.shift).selectByVisibleText(shift);
        dp.date.click();
        dp.date.sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
        sendKeysMethod(dp.date, "04/06/2024 12:00 AM");
        dp.date.sendKeys(Keys.ENTER);
        try {
            WebDriverWait wait=new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
            WebElement fresh=wait.until(ExpectedConditions.refreshed(
                    ExpectedConditions.presenceOfElementLocated(By.id("slot"))));
            new Select(fresh).selectByVisibleText(slot);
        } catch (StaleElementReferenceException e) {
        	System.out.println(e.getMessage());
        }
    }
    public void addedPatient() {
        String expected=reader.getCellData("Sheet1", 0, 0);
        WebDriverWait wait=new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
        try {
            WebElement patientElement=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//tr[@class='odd'])[1]//a")));
            String actual=patientElement.getText();
            Assert.assertTrue(actual.contains(expected));
        } catch (StaleElementReferenceException e) {
            WebElement patientElement = HelperClass.getDriver().findElement(By.xpath("(//tr[@class='odd'])[1]//a"));
            String actualName = patientElement.getText();
            Assert.assertTrue(actualName.contains(expected));
        }
    }
    public void nameRequired(String ex) {
        WebDriverWait wait=new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
        WebElement errorElement=wait.until(ExpectedConditions.visibilityOf(dp.nameError));
        String ac=errorElement.getText();
        log.info("Checking name required validation. Expected: {}, Actual: {}", ex, ac);
        Assert.assertEquals(ac, ex);
    }
    public void saveApp() {
        clickMethod(dp.savebtn);
        log.info("Clicked Save Appointment button");
    }
    public void clickMethod(WebElement ele) {
        ele.click();
    }
    public void sendKeysMethod(WebElement ele, String str) {
        ele.sendKeys(str);
    }
}
