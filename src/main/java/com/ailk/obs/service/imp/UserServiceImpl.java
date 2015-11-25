package com.ailk.obs.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ailk.obs.dao.UserDao;
import com.ailk.obs.model.User;
import com.ailk.obs.service.UserService;

@Component
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	public boolean isRegister(User user) {
		String userName = user.getUserName();
		int userCount = userDao.getByUserName(userName);
		if (userCount > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void register(User user) {
		userDao.addUser(user);
	}

	public boolean login(User user) {
		String userName = user.getUserName();
		String passwd = user.getPassWd();
		List<String> userinfoDB = userDao.getUserByName(userName);
		String passWdDB = userinfoDB.get(1);
		if (passwd.endsWith(passWdDB)) {
			return true;
		} else {
			return false;
		}
	}
}
