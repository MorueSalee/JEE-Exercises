package fr.eni.ecole.ihm;

import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.bo.User;

public class Model {
	private User current;
	private List<User> taskList = new ArrayList<>();
	private String message = "";

	public Model(User current, List<User> taskList, String message) {
		super();
		this.current = current;
		this.taskList = taskList;
		this.message = message;
	}

	public Model(User current, List<User> taskList) {
		super();
		this.current = current;
		this.taskList = taskList;
	}

	public Model() {
		super();
	}

	public User getCurrent() {
		return current;
	}

	public void setCurrent(User current) {
		this.current = current;
	}

	public List<User> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<User> taskList) {
		this.taskList = taskList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
