package com.ailk.obs.service;

import com.ailk.obs.model.User;

public interface UserService {

	public boolean isRegister(User user);
	
	public void register(User user);
	
	public boolean login(User user);
	
}
