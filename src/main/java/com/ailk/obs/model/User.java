package com.ailk.obs.model;

import java.sql.Date;

//”√ªß¿‡
public class User {
	private int userId;
	private String userName;
	private String passWd;
	private String phone;
	private String mail;
	private String sex;
	private String summary;
	private String address;
	private Date createtime;

	public User() {
	}

	public User(String userName, String passWd) {
		this.userName = userName;
		this.passWd = passWd;
	}

	public User(String userName, String passWd, String phone, String mail, String sex, String summary, String address) {
		this.userName = userName;
		this.passWd = passWd;
		this.phone = phone;
		this.mail = mail;
		this.sex = sex;
		this.summary = summary;
		this.address = address;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWd() {
		return passWd;
	}

	public void setPassWd(String passWd) {
		this.passWd = passWd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", passWd=" + passWd + ", phone=" + phone
				+ ", mail=" + mail + ", sex=" + sex + ", summary=" + summary + ", address=" + address + ", createtime="
				+ createtime + "]";
	}

}
