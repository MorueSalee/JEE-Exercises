package fr.eni.ecole.bll;

import java.util.List;

import fr.eni.ecole.bo.Task;
import fr.eni.ecole.dal.DalException;

public interface TaskManager {
	public void addTask(Task task) throws ClassNotFoundException, DalException, BllException;

	public List<Task> getAllTask() throws ClassNotFoundException, DalException, BllException;
	
	public List<Task> getTaskNotDone() throws ClassNotFoundException, DalException;

}
