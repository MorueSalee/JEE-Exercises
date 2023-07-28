package fr.eni.ecole.bll;

import java.util.List;

import fr.eni.ecole.bo.Project;

public interface ProjectManager {
	public void addProject(Project project);
	
	public List<Project> getAllProject();
	
	//public Project getProject(Integer id);
}
