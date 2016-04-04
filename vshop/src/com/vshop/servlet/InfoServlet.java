package com.vshop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vshop.entity.User;
import com.vshop.service.IUserService;
import com.vshop.service.impl.UserServiceImpl;

public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		HttpSession session = req.getSession();
		String username = session.getAttribute("username").toString();
		//if (username != null && !username.equals("")) {

			IUserService userService = new UserServiceImpl();

			User user = userService.getUserByuserID(username);
			req.setAttribute("user", user);
			req.getRequestDispatcher("info.jsp").forward(req, resp);
		/*} else {
			resp.sendRedirect(req.getContextPath() + "/index.jsp");
		}*/

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
