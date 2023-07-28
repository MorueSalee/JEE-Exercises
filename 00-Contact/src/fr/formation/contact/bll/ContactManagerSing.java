package fr.formation.contact.bll;

public class ContactManagerSing {
	private static ContactManager instance;
	
	public static ContactManager getInstance() {
		if(instance==null) {
			instance = new ContactManagerImpl();
		}
		return instance;
	}
}
