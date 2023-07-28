package fr.eni.ecole.dal;

import java.util.List;

import fr.eni.ecole.bo.Sweet;

public interface DAO {
	public Sweet selectById(Integer id) throws DalException, ClassNotFoundException;

	public List<Sweet> selectAll() throws DalException, ClassNotFoundException;

	public void update(Sweet sweet) throws DalException, ClassNotFoundException;

	public void insert(Sweet sweet) throws DalException, ClassNotFoundException;

	public void delete(int id) throws DalException, ClassNotFoundException;
}
