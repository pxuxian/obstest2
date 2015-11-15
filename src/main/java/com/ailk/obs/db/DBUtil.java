package com.ailk.obs.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ailk.obs.util.PropertiesUtil;

public class DBUtil {
	private final static String DBDRIVER = PropertiesUtil.getInstance().get("DB_DRIVER");
	private final static String DBURL = PropertiesUtil.getInstance().get("DB_URL");
	private final static String DBUSER = PropertiesUtil.getInstance().get("DB_USERNAME");
	private final static String DBPASSWORD = PropertiesUtil.getInstance().get("DB_PASSWORD");

	// 获得数据库连接
	public static Connection getConnection() {
		try {
			Class.forName(DBDRIVER);
			Connection conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * 执行select查询，返回记录总数
	 */
	public static int executeSelect(String sql) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			int count = 0;
			while (rs.next()) {
				count++;
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
			close(conn);
		}
		return 0;

	}

	/**
	 * 执行select查询 当查询 结果有多条记录时返回每条记录的第一个值 放入 List； 当查询结果为一条记录的多个字段时，把每个字段放入List；
	 * 
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public static List<String> executeSelectRS(String sql) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<String> list = new ArrayList<String>();
		int count = executeSelect(sql);
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			// 总列数int
			int size = rsmd.getColumnCount();
			// 多列一条记录
			if (count == 1) {
				while (rs.next()) {
					for (int i = 1; i <= size; i++) {
						String columnName = rsmd.getColumnName(i);
						System.out.println("columnName = " + columnName);
						String value = rs.getString(columnName);
						System.out.println("columnValue = " + value);
						list.add(value);
					}
				}
			} else {
				// 一列多条记录
				while (rs.next()) {
					list.add(rs.getString(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
			close(conn);
		}
		return list;
	}

	/*
	 * insert, update,delete
	 */

	public static int executeSql(String sql) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			stmt = conn.createStatement();
			return stmt.executeUpdate(sql);
		} catch (Exception e) {
			throw e;
		} finally {
			close(rs);
			close(stmt);
			close(conn);
		}

	}

}
