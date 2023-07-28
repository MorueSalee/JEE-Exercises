package fr.formation.contact.dal;

import java.util.ArrayList;
import java.util.List;

import fr.formation.contact.bo.Contact;

public class ContactDAOMock implements ContactDAO {

	private List<Contact> lstContacts = new ArrayList<Contact>();
	
	@Override
	public void insert(Contact contact) {
		System.out.println("J'insère en base de données :=) ");
		lstContacts.add(contact);
	}

	@Override
	public List<Contact> getAll() {
		System.out.println("je récupère en base de données");
		return lstContacts;
	}

}
