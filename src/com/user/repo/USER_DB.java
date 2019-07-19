package com.user.repo;

import java.util.HashMap;

import com.user.beans.User;

public class USER_DB {
	static HashMap<Integer,User> hm=new HashMap<Integer,User>();
	
	public boolean addUser(User user){
		//add user into HashMap if not exists
		if(hm.containsKey(user.getId())){
			 
			 return false;
		}
		else{
			hm.put(user.getId(), user);
			 return true;
		}
		
	}
	public User getUser(int id){
		//return user detail if exists
		if(hm.containsKey(id)){
			return hm.get(id);
		}
		else
			return null;
	}
	public boolean updateUser(User user){
		//update user detail if exists in map
		if(hm.containsKey(user.getId())){
			 
			hm.put(user.getId(), user);
			return true;
		}
		else{
			
			 return false;
		}
	}
	public boolean deleteUser(int id){
		//delete user if exists in map
		if(hm.containsKey(id)){
			 
			hm.remove(id);
			return true;
		}
		else{
			
			 return false;
		}
	}
}
