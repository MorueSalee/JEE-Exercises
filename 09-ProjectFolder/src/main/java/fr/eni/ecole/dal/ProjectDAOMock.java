package fr.eni.ecole.dal;

import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.bo.Project;

public class ProjectDAOMock implements ProjectDAO {
	private List<Project> listProject = new ArrayList<Project>();

	@Override
	public void insert(Project project) {
		listProject.add(project)		;
	}

	@Override
	public List<Project> getAll() {
		return listProject;
	}

}
