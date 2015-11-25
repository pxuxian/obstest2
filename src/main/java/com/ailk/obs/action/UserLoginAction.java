package com.ailk.obs.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.ailk.obs.model.User;
import com.ailk.obs.service.UserService;

@Scope("prototype")
@ParentPackage("basePackage")
@Namespace("/")
public class UserLoginAction {
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	@Autowired
	private UserService userService;
	private String userName;
	private String passWd;

	@Action(value = "login", results = { @Result(name = "success", location = "/result.jsp"),
			@Result(name = "error", location = "/error.jsp") })
	public String execute() {
		System.out.println("UserLoginAction.execute()....");
		System.out.println("userName = " + userName);

		User user = new User(userName, passWd);
		boolean loginResult = false;
		try {
			loginResult = userService.login(user);
			request.setAttribute("info", "login success!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!loginResult) {
			request.setAttribute("info", "login fail!");
		}
		return "success";
	}

	public String getuserName() {
		return userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}

	public String getpassWd() {
		return passWd;
	}

	public void setpassWd(String passWd) {
		this.passWd = passWd;
	}

}
