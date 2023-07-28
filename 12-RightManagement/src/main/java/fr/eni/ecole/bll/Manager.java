package fr.eni.ecole.bll;

import java.util.List;

import fr.eni.ecole.bo.User;
import fr.eni.ecole.dal.DalException;

public interface Manager {
	public void addUser(User user) throws ClassNotFoundException, DalException, BllException;

	public List<User> getAllUser() throws ClassNotFoundException, DalException, BllException;

	public User checkUser(String login, String password) throws ClassNotFoundException, DalException, BllException;

}
