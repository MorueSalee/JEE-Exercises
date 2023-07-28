package fr.formation.biere.bll;

import java.util.List;

import fr.formation.biere.bo.Biere;
import fr.formation.biere.dal.DalException;

public interface BiereManager {
	
	public void addBiere(Biere biere) throws DalException, AlcoolException;
	
	public List<Biere> getAllBiere() throws DalException, AlcoolException;
}
