package fr.formation.biere.dal;

public class DAOFact {
	public static BiereDAO getBiereDAO() {
		return new BiereDAOImpl();
	}
}
