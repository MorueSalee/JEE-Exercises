package fr.eni.ecole.bll;

public class SweetManagerSing {
	private static SweetManager instance;

	public static SweetManager getInstance() {
		if (instance == null) {
			instance = new SweetManagerImpl();
		}
		return instance;
	}
}
