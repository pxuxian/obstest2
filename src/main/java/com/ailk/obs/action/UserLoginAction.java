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

	@Action(value = "login", results = { @Result(name = "success", location = "/result.jsp"),
			@Result(name = "error", location = "/error.jsp") })
	public String login() {
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		User user = new User(userName, passWord);
		boolean loginResult = false;
		try {
			loginResult = userService.login(user);
			request.setAttribute("info", "登入成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!loginResult) {
			request.setAttribute("info", "登入失败");
		}
		return "success";
	}

}
