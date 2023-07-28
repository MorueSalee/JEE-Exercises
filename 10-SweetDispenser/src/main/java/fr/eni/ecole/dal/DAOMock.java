package fr.eni.ecole.dal;

import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.bo.Sweet;

public class DAOMock implements DAO{
	private List<Sweet> sweetList = new ArrayList<Sweet>();

	@Override
	public Sweet selectById(Integer id) throws DalException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sweet> selectAll() throws DalException {
		return sweetList;
	}

	@Override
	public void update(Sweet sweet) throws DalException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Sweet sweet) throws DalException {
		sweetList.add(sweet);
	}

	@Override
	public void delete(int id) throws DalException {
		// TODO Auto-generated method stub
		
	}

}
