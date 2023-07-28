package fr.formation.biere.bll;

public class BiereManagerSing {	
	
	private static BiereManager instance;
	
	public static BiereManager getInstance() {
		if(instance==null) {
			instance = new BiereManagerImpl();
		}
		return instance;
	}
}
