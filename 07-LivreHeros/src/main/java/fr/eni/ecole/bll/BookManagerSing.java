package fr.eni.ecole.bll;


public class BookManagerSing {
	
private static BookManager instance;
	
	public static BookManager getInstance() {
		if(instance==null) {
			instance = new BookManagerImpl();
		}
		return instance;
	}

}
