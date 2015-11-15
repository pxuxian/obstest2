package com.ailk.obs.web;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ailk.obs.model.User;
import com.ailk.obs.service.UserService;
import com.ailk.obs.service.imp.UserServiceImpl;

public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1367941784575108588L;

	private UserService userService;

	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		String userName = request.getParameter("userName");
		String passWd = request.getParameter("passWd");
		String phone = request.getParameter("phone");
		String mail = request.getParameter("mail");
		String sex = request.getParameter("sex");
		String summary = request.getParameter("summary");
		String address = request.getParameter("address");

		User user = new User(userName, passWd, phone, mail, sex, summary, address);
		boolean result = userService.isRegister(user);

		if (result == true) {
			request.setAttribute("info", "×¢²á³É¹¦£¡");
		} else {
			request.setAttribute("info", "×¢²áÊ§°Ü£¡");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
		dispatcher.forward(request, response);
	}

}
