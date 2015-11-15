package com.ailk.obs.dao;

import java.util.List;

import org.junit.Test;

import com.ailk.obs.dao.impl.UserDaoImpl;
import com.ailk.obs.model.User;

import junit.framework.Assert;

public class UserDaoTest {
	UserDao userDao = new UserDaoImpl();
	User user = new User();

	@Test
	public void testGet() {

		int userCount = userDao.getByUserName("wangjing");
		System.out.println("userCount==" + userCount);
		Assert.assertEquals(1, userCount);
	}

	@Test
	public void testGetUser() {
		List<String> userinfoList = userDao.getUserByName("wangjing1");
		if (userinfoList != null && userinfoList.size() > 0) {
			String userNameDB = userinfoList.get(0);
			String passWdDB = userinfoList.get(1);
			System.out.println(userNameDB);
			System.out.println(passWdDB);
		}
	}

	@Test
	public void testSet() {

		user.setUserName("wangjing");
		user.setPassWd("wangjing");
		user.setPhone("13577777777");
		user.setMail("wangjing@163.com");
		user.setSex("0");
		user.setSummary("beijing");
		user.setAddress("beijing");
		userDao.addUser(user);
	}

}
