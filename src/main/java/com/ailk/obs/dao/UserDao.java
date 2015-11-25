package com.ailk.obs.dao;

import java.util.List;

import com.ailk.obs.model.User;

public interface UserDao {
	
	int getByUserName(String userName);

	List<String> getUserByName(String userName);

	void addUser(User user);

}
