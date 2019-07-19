package com.user.dao;

import com.user.beans.User;
import com.user.repo.USER_DB;

public class DAOImpl implements DAO{
	USER_DB udb=new USER_DB();
	@Override
	public boolean addUser(User user) {
		return udb.addUser(user);
	}

	@Override
	public User getUser(int id) {
		return udb.getUser(id);
	}

	@Override
	public boolean updateUser(User user) {
		return udb.updateUser(user);
	}

	@Override
	public boolean deleteUser(int id) {
		return udb.deleteUser(id);
	}

}
