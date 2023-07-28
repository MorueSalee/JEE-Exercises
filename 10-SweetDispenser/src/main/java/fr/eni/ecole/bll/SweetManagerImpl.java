package fr.eni.ecole.bll;

import java.util.List;

import fr.eni.ecole.bo.Sweet;
import fr.eni.ecole.dal.DAO;
import fr.eni.ecole.dal.DAOFact;
import fr.eni.ecole.dal.DalException;


public class SweetManagerImpl implements SweetManager {
	private DAO dao = DAOFact.getSweetDAO();

	@Override
	public void addSweet(Sweet sweet) throws DalException, ClassNotFoundException {
		dao.insert(sweet);
	}

	@Override
	public Sweet getSweet(Integer id) throws DalException, ClassNotFoundException {
		return dao.selectById(id);
	}

	@Override
	public List<Sweet> getAllSweet() throws DalException, ClassNotFoundException {
		return dao.selectAll();
	}

	@Override
	public void updateSweet(Sweet sweet) throws DalException, ClassNotFoundException {
		dao.update(sweet);
	}

	@Override
	public void deleteSweet(Integer id) throws DalException, ClassNotFoundException {
		dao.delete(id);
	}

}
