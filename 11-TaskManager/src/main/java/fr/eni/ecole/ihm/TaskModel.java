package fr.eni.ecole.ihm;

import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.bo.Task;

public class TaskModel {
	private Task current;
	private List<Task> taskList = new ArrayList<>();
	private String message = "";

	public TaskModel() {
		super();
	}

	public TaskModel(Task current, List<Task> taskList, String message) {
		super();
		this.current = current;
		this.taskList = taskList;
		this.message = message;
	}

	public Task getCurrent() {
		return current;
	}

	public void setCurrent(Task current) {
		this.current = current;
	}

	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
