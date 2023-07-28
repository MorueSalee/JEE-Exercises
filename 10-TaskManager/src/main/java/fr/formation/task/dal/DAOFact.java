package fr.formation.task.dal;

public class DAOFact {
	public static TaskDAO getTaskDAO() {
		return new TaskDAOImpl();
	}
}
