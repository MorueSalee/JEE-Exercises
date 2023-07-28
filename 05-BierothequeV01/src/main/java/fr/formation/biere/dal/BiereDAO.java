package fr.formation.biere.dal;

import java.util.List;

import fr.formation.biere.bo.Biere;

public interface BiereDAO {
	public void insert(Biere biere) throws DalException;
	public List<Biere> getAll() throws DalException;
}
