package com.user.services;

import com.user.beans.User;
import com.user.dao.DAO;
import com.user.dao.DAOImpl;

public class ServicesImpl implements Services{
	DAO dao=new DAOImpl();
	@Override
	public boolean addUser(User user) {
		
		return dao.addUser(user);
	}

	@Override
	public User getUser(int id) {
		return dao.getUser(id);
	}

	@Override
	public boolean updateUser(User user) {
		return dao.updateUser(user);
	}

	@Override
	public boolean deleteUser(int id) {
		return dao.deleteUser(id);
	}

}
