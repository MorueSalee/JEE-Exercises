package fr.eni.ecole.ihm;

import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.bo.Person;

public class PassionModel {
	
	private Person current = new Person();
	private List<String> listPassion = new ArrayList<>(); 
	private String message ="";
	
	public PassionModel() {
		super();
	}

	public PassionModel(Person current, String message) {
		super();
		this.current = current;
		this.message = message;
	}

	public Person getCurrent() {
		return current;
	}

	public void setCurrent(Person current) {
		this.current = current;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "PassionModel [current=" + current + ", message=" + message + "]";
	}

	public List<String> getListPassion() {
		return listPassion;
	}

	public void setListPassion(List<String> listPassion) {
		this.listPassion = listPassion;
	}
	
	
	
	
	

}
