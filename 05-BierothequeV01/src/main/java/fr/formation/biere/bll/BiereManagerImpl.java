package fr.formation.biere.bll;

import java.util.Collections;
import java.util.List;

import fr.formation.biere.bo.Biere;
import fr.formation.biere.dal.BiereDAO;
import fr.formation.biere.dal.DAOFact;
import fr.formation.biere.dal.DalException;

public class BiereManagerImpl implements BiereManager {
	private BiereDAO dao = DAOFact.getBiereDAO();
	
	@Override
	public void addBiere(Biere biere) throws AlcoolException, DalException {
		if(biere.getAlcool()<=0.5) {
			throw new AlcoolException("Merci d'insérer une VRAIE bière avec un VRAI taux d'alcool !");
		}else {
			dao.insert(biere);
		}
	}

	@Override
	public List<Biere> getAllBiere() throws DalException {
		return dao.getAll();
	}

}
