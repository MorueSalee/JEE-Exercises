package fr.formation.biere.test;

import fr.formation.biere.bll.AlcoolException;
import fr.formation.biere.bll.BiereManager;
import fr.formation.biere.bll.BiereManagerSing;
import fr.formation.biere.bo.Biere;
import fr.formation.biere.dal.DalException;

public class ManagerTest {
	public static BiereManager manager = BiereManagerSing.getInstance();
	public static void main(String[] args) throws DalException, AlcoolException {
		//Biere trimatelod = new Biere("Tri Matelod","Blonde","Tri Matelod",5.0,"vraiment bien avec une galette oui je provoque car dit crêpe salée",5);
		//manager.addBiere(trimatelod);
		
		manager.getAllBiere().forEach(System.out::println);
	}

}
