package fr.eni.ecole.bll;

import java.util.List;

import fr.eni.ecole.bo.User;
import fr.eni.ecole.dal.DAO;
import fr.eni.ecole.dal.DAOFact;
import fr.eni.ecole.dal.DalException;

public class ManagerImpl implements Manager {
	private DAO dao = DAOFact.getDAO();

	@Override
	public void addUser(User user) throws ClassNotFoundException, DalException, BllException {
		dao.insert(user);
	}

	@Override
	public List<User> getAllUser() throws ClassNotFoundException, DalException, BllException {
		return dao.selectAll();
	}

	@Override
	public User checkUser(String login, String password) throws ClassNotFoundException, DalException, BllException {
		List<User> userList = getAllUser();

		for (User user : userList) {
			if (login.equals(user.getLogin()) && password.equals(user.getPassword())) {
				return user;
			} else {
				return null;
			}
		}
		return null;
	}

}
