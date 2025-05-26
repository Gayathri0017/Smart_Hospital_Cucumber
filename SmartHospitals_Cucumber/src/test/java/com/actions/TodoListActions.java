package com.actions;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.pages.ToDoListPage;
import com.utils.HelperClass;
public class TodoListActions {
	ToDoListPage tp=null;
	CommonActions ca=new CommonActions();
	public TodoListActions(){
		this.tp=new ToDoListPage();
		PageFactory.initElements(HelperClass.getDriver(),tp);
	}
	public void clickCalander() {
		ca.ClickFun(tp.calander);
	}
	public void clickAdd() {
		ca.ClickFun(tp.add);
	}
	public void addTasks(String t,String date) {
		sendKeysMethod(tp.task,t);
		sendKeysMethod(tp.date,date);
	}
	public void assertTask(String name){
		List<WebElement> tasks=HelperClass.getDriver().findElements(By.xpath("//div[@class='media mt5']/div[@class='media-body']/p"));
		for(WebElement task:tasks) {
			String text=task.getText();
			if(name.equals(text)) {
				Assert.assertEquals(text,name);
				break;
			}
		}
	}
	 public void clickMethod(WebElement ele) {
	        ele.click();
	 }
	 public void sendKeysMethod(WebElement ele, String str) {
	        ele.sendKeys(str);
	 }
}
