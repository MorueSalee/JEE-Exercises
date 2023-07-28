package fr.eni.ecole.dal;


public class TaskDAOFact {
	public static TaskDAO getTaskDAO() {
		return new TaskDAOImpl();
	}
}
