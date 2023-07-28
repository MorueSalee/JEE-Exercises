package fr.eni.ecole.dal;

import java.util.List;

import fr.eni.ecole.bo.User;

public interface DAO {
	public void insert(User user) throws DalException, ClassNotFoundException;
	public List<User> selectAll() throws DalException, ClassNotFoundException;
}
