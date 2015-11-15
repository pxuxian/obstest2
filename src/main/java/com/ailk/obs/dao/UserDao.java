package com.ailk.obs.dao;

import java.util.List;

import com.ailk.obs.model.User;

public interface UserDao {
	// 库中是否有记录
	int getByUserName(String userName);

	// 通过username获得userInfo
	List<String> getUserByName(String userName);

	// 用户信息入库
	void addUser(User user);

}
