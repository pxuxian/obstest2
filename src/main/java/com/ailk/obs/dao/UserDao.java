package com.ailk.obs.dao;

import java.util.List;

import com.ailk.obs.model.User;

public interface UserDao {
	// �����Ƿ��м�¼
	int getByUserName(String userName);

	// ͨ��username���userInfo
	List<String> getUserByName(String userName);

	// �û���Ϣ���
	void addUser(User user);

}
