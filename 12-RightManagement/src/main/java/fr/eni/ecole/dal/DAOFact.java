package fr.eni.ecole.dal;

public class DAOFact {
	public static DAO getDAO() {
		return new DAOMock();
	}
}
