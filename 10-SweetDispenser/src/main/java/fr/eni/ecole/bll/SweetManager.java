package fr.eni.ecole.bll;

import java.util.List;

import fr.eni.ecole.bo.Sweet;
import fr.eni.ecole.dal.DalException;

public interface SweetManager {
	public void addSweet(Sweet sweet) throws DalException, ClassNotFoundException;

	public Sweet getSweet(Integer id) throws DalException, ClassNotFoundException;

	public List<Sweet> getAllSweet() throws DalException, ClassNotFoundException;

	public void updateSweet(Sweet sweet) throws DalException, ClassNotFoundException;

	public void deleteSweet(Integer id) throws DalException, ClassNotFoundException;
}
