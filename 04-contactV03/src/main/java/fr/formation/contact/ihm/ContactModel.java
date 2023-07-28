package fr.formation.contact.ihm;

import java.util.ArrayList;
import java.util.List;

import fr.formation.contact.bo.Contact;

public class ContactModel {
	private Contact current = new Contact("", "", "00000000");
	private List<Contact> lstContacts = new ArrayList<>();
	private String message = "";

	public ContactModel() {
	}

	public ContactModel(Contact current, List<Contact> lstContacts, String message) {
		super();
		this.current = current;
		this.lstContacts = lstContacts;
		this.message = message;
	}

	public Contact getCurrent() {
		return current;
	}

	public void setCurrent(Contact current) {
		this.current = current;
	}

	public List<Contact> getLstContacts() {
		return lstContacts;
	}

	public void setLstContacts(List<Contact> lstContacts) {
		this.lstContacts = lstContacts;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ContactModel [current=" + current + ", lstContacts=" + lstContacts + ", message=" + message + "]";
	}

}
