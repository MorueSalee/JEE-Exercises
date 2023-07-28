package fr.formation.contact.bll;

import java.util.List;

import fr.formation.contact.bo.Contact;
import fr.formation.contact.dal.ContactDAO;
import fr.formation.contact.dal.DAOFact;

public class ContactManagerImpl implements ContactManager {
	private ContactDAO dao = DAOFact.getContactDAO();
	
	@Override
	public void addContact(Contact contact) {
		if("Dupont".equals(contact.getNom())||"Dupond".equals(contact.getNom())) {
			System.out.println("ERREUR : pas de Dupont");
		}
		else {
			dao.insert(contact);
		}
	}

	@Override
	public List<Contact> getAllContact() {
		return dao.getAll();
	}

}
