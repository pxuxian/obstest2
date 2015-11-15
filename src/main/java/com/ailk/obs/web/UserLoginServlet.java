package com.ailk.obs.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ailk.obs.model.User;
import com.ailk.obs.service.UserService;
import com.ailk.obs.service.imp.UserServiceImpl;

public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1367941784575108588L;
	private UserService userService;

	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl();
	}
	
//	@Override
//	protected void service(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String userName = request.getParameter("userName");
//		String passWord = request.getParameter("passWord");
//		User user = new User(userName, passWord);
//		boolean loginResult = false;
//		try {
//			loginResult = userService.login(user);
//			response.getWriter().write("����ɹ�");
//			response.flushBuffer();
//			return;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		if (!loginResult) {
//			response.getWriter().write("����ʧ��");
//			response.flushBuffer();
//		}
//	}

	/**
	 * �ڲ���ת
	 */
//	@Override
//	protected void service(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String userName = request.getParameter("userName");
//		String passWord = request.getParameter("passWord");
//		User user = new User(userName, passWord);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
//		boolean loginResult = false;
//		try {
//			loginResult = userService.login(user);
//			request.setAttribute("info", "����ɹ�");
//			dispatcher.forward(request, response);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		if (!loginResult) {
//			request.setAttribute("info", "����ʧ��");
//			dispatcher.forward(request, response);
//		}
//	}
	
	/**
	 * �ض���
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		User user = new User(userName, passWord);
		try {
//			userService.login(user);
			request.getSession().setAttribute("userName", "abc");
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("/result.jsp");
	}
}
