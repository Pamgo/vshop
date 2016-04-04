package com.vshop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vshop.entity.User;
import com.vshop.service.IUserService;
import com.vshop.service.impl.UserServiceImpl;

public class SelectUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			String user_id = req.getParameter("user_id");
			
			IUserService userService = new  UserServiceImpl();
			User userOwn = userService.findUserMsgByUserId(user_id);
			req.setAttribute("userOwn", userOwn);
			req.getRequestDispatcher("user.jsp").forward(req, resp);
			
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

				doGet(req, resp);
		}
}
