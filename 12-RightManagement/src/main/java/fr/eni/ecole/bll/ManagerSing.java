package fr.eni.ecole.bll;

public class ManagerSing {
	private static Manager instance;

	public static Manager getInstance() {
		if (instance == null) {
			instance = new ManagerImpl();
		}
		return instance;
	}
}
