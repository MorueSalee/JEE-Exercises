package fr.eni.ecole.dal;

import java.util.List;

import fr.eni.ecole.bo.Task;

public interface TaskDAO {
	public void insert(Task task) throws DalException, ClassNotFoundException;
	public List<Task> selectAll() throws DalException, ClassNotFoundException;
    public List<Task> selectAllNotDoneOrderedByPriority() throws DalException, ClassNotFoundException;

}
