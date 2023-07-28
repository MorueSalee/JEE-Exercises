package fr.eni.ecole.dal;

import java.util.List;

import fr.eni.ecole.bo.Project;

public interface ProjectDAO {
	public void insert(Project project);
	public List<Project> getAll();
}
