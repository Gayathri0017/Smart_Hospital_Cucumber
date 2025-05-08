package com.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import com.pages.*;

public class SmartHospitalActions {

    private SmartHospitalPage page;

    public SmartHospitalActions(WebDriver driver) {
        this.page = new SmartHospitalPage(driver);
    }

    public void clickReport() {
        page.getReportButton().click();
    }

    public void clickFinance() {
        page.getFinanceButton().click();
    }

    public void selectAllTransactionReport() {
        page.getAllTransactionReport().click();
    }

    public void selectLastWeek() {
        Select select = new Select(page.getDropdown());
        select.selectByVisibleText("Last Week");
    }

    public void clickSearch() {
        page.getSearchButton().click();
    }

    public double getTotalAmountFromTable() {
        double totalAmount = 0.0;
        WebElement table = page.getTransactionsTable();
        WebElement tbody = table.findElement(By.tagName("tbody"));
        for (WebElement row : tbody.findElements(By.tagName("tr"))) {
            WebElement amountCell = row.findElements(By.tagName("td")).get(2);
            totalAmount += Double.parseDouble(amountCell.getText().replace(",", ""));
        }
        return totalAmount;
    }

    public double getTotalAmountDisplayed() {
        return Double.parseDouble(page.getTotalAmount().getText().replace(",", ""));
    }
}
