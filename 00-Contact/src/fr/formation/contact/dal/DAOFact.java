package fr.formation.contact.dal;

public class DAOFact {
	public static ContactDAO getContactDAO() {
		return new ContactDAOMock();
	}
}
