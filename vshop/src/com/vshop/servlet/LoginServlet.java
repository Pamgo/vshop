package com.vshop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vshop.service.IUserService;
import com.vshop.service.impl.UserServiceImpl;
import com.vshop.util.StringHelper;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		//System.out.println("login ...");
		String account = req.getParameter("account");
		String password = req.getParameter("password");
		IUserService userService = new UserServiceImpl();
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession();
		String result = userService.login(account, StringHelper.MD5(password));
		if (result.equals("3")) {
			session.setAttribute("username", account);
			session.setMaxInactiveInterval(3600);
		}
		out.println(result);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
