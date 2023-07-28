package fr.formation.biere.dal;

import java.util.ArrayList;
import java.util.List;

import fr.formation.biere.bo.Biere;

public class BiereDAOMock implements BiereDAO {
	private List<Biere> lstBieres = new ArrayList<>();
	
	@Override	
	public void insert(Biere biere) {
		lstBieres.add(biere);
	}

	@Override
	public List<Biere> getAll() {
		return lstBieres;
	}

}
