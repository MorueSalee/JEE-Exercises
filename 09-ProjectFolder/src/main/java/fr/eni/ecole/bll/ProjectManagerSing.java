package fr.eni.ecole.bll;

public class ProjectManagerSing {
	private ProjectManagerImpl instance;
	
	public ProjectManagerImpl getInstance() {
		if (instance == null) {
			instance = new ProjectManagerImpl();
		}
		return instance;
	}
}
