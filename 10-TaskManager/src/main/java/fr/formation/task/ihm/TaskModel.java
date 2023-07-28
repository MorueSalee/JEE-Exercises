package fr.formation.task.ihm;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.formation.task.bo.Task;

public class TaskModel {
	private String message = "";
	private Task current = new Task("", LocalDateTime.now(), LocalDateTime.now().plusDays(1), 0, false);
	private List<Task> lstTasks = new ArrayList<>();

	public TaskModel() {
	}

	public TaskModel(String message, Task current, List<Task> lstTasks) {
		super();
		this.message = message;
		this.current = current;
		this.lstTasks = lstTasks;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Task getCurrent() {
		return current;
	}

	public void setCurrent(Task current) {
		this.current = current;
	}

	public List<Task> getLstTasks() {
		return lstTasks;
	}

	public void setLstTasks(List<Task> lstTasks) {
		this.lstTasks = lstTasks;
	}

	@Override
	public String toString() {
		return "TaskModel [message=" + message + ", current=" + current + ", lstTasks=" + lstTasks + "]";
	}

}
