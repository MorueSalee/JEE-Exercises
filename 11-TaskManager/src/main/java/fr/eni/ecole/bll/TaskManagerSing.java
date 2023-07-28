package fr.eni.ecole.bll;

public class TaskManagerSing {
	private static TaskManager instance;

	public static TaskManager getInstance() {
		if (instance == null) {
			instance = new TaskManagerImpl();
		}
		return instance;
	}
}
