package com.user.dao;

import com.user.beans.User;

public interface DAO {
	public boolean addUser(User user);
	public User getUser(int id);
	public boolean updateUser(User user);
	public boolean deleteUser(int id);
}
