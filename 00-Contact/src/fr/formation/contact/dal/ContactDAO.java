package fr.formation.contact.dal;

import java.util.List;

import fr.formation.contact.bo.Contact;

public interface ContactDAO {
	public void insert(Contact contact);
	public List<Contact> getAll();
}
