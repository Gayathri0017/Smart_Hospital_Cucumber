package com.definitions;
import java.util.List;
import java.util.Map;

import com.actions.TodoListActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class TodoListDefinition {
	String task=null;
	TodoListActions ta=new TodoListActions();
	@When("the doctor clicks the calendar")
	public void the_doctor_clicks_the_calendar() {
	    ta.clickCalander();
	}
	@When("clicks the plus icon to add a task")
	public void clicks_the_plus_icon_to_add_a_task() {
	    ta.clickAdd();
	}
	@When("fills in the task details")
	public void fills_in_the_task_details(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
	    Map<String, String> row = rows.get(0);
	    task=row.get("task");
	    String date=row.get("date");
	    ta.addTasks(task, date);
	}
	@Then("the task should be visible in the To Do List")
	public void the_task_should_be_visible_in_the_to_do_list() {
	    ta.assertTask(task);
	}
}
