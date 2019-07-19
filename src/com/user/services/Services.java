package com.user.services;

import com.user.beans.User;

public interface Services {
	public boolean addUser(User user);
	public User getUser(int id);
	public boolean updateUser(User user);
	public boolean deleteUser(int id);
}
