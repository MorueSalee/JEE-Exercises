package fr.eni.ecole.ihm;

import java.util.ArrayList;
import java.util.List;

public class BookModel {

	private List<String> inventory = new ArrayList<>();

	private String message;

	public BookModel() {
	}

	public BookModel(List<String> inventory) {
		super();
		this.inventory = inventory;
	}

	public List<String> getInventory() {
		return inventory;
	}

	public void setInventory(List<String> inventory) {
		this.inventory = inventory;
	}

	public void addObject(String object) {
		this.inventory.add(object);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
