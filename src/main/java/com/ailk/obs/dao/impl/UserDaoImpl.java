package com.ailk.obs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Component;
import com.ailk.obs.dao.UserDao;
import com.ailk.obs.db.DBUtil;
import com.ailk.obs.model.User;

@Component
public class UserDaoImpl implements UserDao {

	public int getByUserName(String userName) {
		String sql = "select * from t_user where userName='" + userName + "'";
		System.out.println("sql === " + sql);
		return DBUtil.executeSelect(sql);
	}

	public List<String> getUserByName(String userName) {
		String sql = "select  username,passwd from  t_user where userName = '" + userName + "'";
		List<String> userList = DBUtil.executeSelectRS(sql);
		return userList;
	}

	public void addUser(User user) {

		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement("insert into t_user(userName,passWd,phone,mail,sex,summary,address,createtime) values(?,?,?,?,?,?,?,now())");
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassWd());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getMail());
			ps.setString(5, user.getSex());
			ps.setString(6, user.getSummary());
			ps.setString(7, user.getSummary());
			ps.executeUpdate();
			ps.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

