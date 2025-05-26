package com.actions;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.pages.PatientChargePage;
import com.utils.HelperClass;

public class PatientChargeActions {
	private static final Logger log = LogManager.getLogger(PatientChargeActions.class);
	PatientChargePage PCP = null ;
	float sum = 0 ;
	public PatientChargeActions() {
		PCP = new PatientChargePage();
		PageFactory.initElements(HelperClass.getDriver(), PCP);
	}
	
	public void ClickChargeBtn() {
		PCP.chargebtn.click();
		log.info("Charge btn is clicked successfully");
	}
	public void getPatientChargeDetails() {
		
		 List<WebElement> datas = HelperClass.getDriver().findElements(By.xpath("//table[@id='DataTables_Table_4']/tbody[1]/tr[1]/td"));

		 for (int i = 1 ; i < 5 ; i++) {
			 for (int j = 1 ; j <= datas.size() ; j++ ) {
				 WebElement headText = HelperClass.getDriver().findElement(By.xpath("//table[@id='DataTables_Table_4']/thead/tr/th["+j+"]"));
				 
				 WebElement datasText = HelperClass.getDriver().findElement(By.xpath("//table[@id='DataTables_Table_4']/tbody[1]/tr["+i+"]/td["+j+"]"));
				 if (headText.getText().equals("Amount")) {
					 String value = datasText.getText().replace(",", "").trim();
					 sum += Float.parseFloat(value);
				 }
				 System.out.println(headText.getText()+" : "+datasText.getText());
				 
			 }
			 System.out.println("Sum : "+sum);
			 System.out.println("-----------------------------"); 
		 }
	}
	
	public float getTotal() {
		float amount = Float.parseFloat(PCP.total_amount.getText().replace("Total: $", "").trim());
		return  amount;
	}

	public float getActualAmount() {
		return sum;
	}
}
