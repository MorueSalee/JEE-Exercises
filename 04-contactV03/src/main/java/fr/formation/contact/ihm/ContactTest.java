package fr.formation.contact.ihm;

import fr.formation.contact.bll.ContactManager;
import fr.formation.contact.bll.ContactManagerSing;
import fr.formation.contact.bo.Contact;

public class ContactTest {
	private static ContactManager manager = ContactManagerSing.getInstance();
	
	public static void main(String[] args) {
		manager.addContact(new Contact("Cérien","Jean","215454755"));
		manager.addContact(new Contact("Terrieur","Alain","254755"));
		manager.addContact(new Contact("Terrieur","Alex","254755"));
		manager.addContact(new Contact("Dupont","Jean","154454"));
		System.out.println(manager.getAllContact());
	}

}
