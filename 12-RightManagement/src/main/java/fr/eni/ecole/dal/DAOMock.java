package fr.eni.ecole.dal;

import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.bo.User;

public class DAOMock implements DAO{
	private static List<User> userList = new ArrayList<User>();
	private static Integer id = 1;

	@Override
	public void insert(User user) throws DalException, ClassNotFoundException {
		if (userList.size() > 0) {
			id = userList.size() + 1;
		}
		
		user.setIdUser(id);
		userList.add(user);
	}

	@Override
	public List<User> selectAll() throws DalException, ClassNotFoundException {
		return userList;
	}
	
}
