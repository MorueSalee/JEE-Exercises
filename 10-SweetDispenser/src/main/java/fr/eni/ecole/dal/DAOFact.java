package fr.eni.ecole.dal;

import fr.eni.ecole.dal.jdbc.SweetDAOImpl;

public class DAOFact {
	public static DAO getSweetDAO() {
		return new SweetDAOImpl();
	}
}
